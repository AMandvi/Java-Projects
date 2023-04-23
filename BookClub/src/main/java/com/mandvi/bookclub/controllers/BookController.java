package com.mandvi.bookclub.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mandvi.bookclub.models.Book;
import com.mandvi.bookclub.models.User;
import com.mandvi.bookclub.services.BookService;
import com.mandvi.bookclub.services.UserService;

@Controller
public class BookController {
	@Autowired
	private BookService bookServ;
	@Autowired
	private UserService userServ;

	@GetMapping("/books")
	public String index(HttpSession s, Model model) {
		Long userId = (Long) s.getAttribute("user_id");
		// check if this in session
		if (userId == null) {
			return "redirect:/";
		} else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
			// get the books
			List<Book> allDaBooks = bookServ.allBooks();
			// pass the books to the jsp
			model.addAttribute("allDaBooks", allDaBooks);
			return "index.jsp";
		}

	}

	@GetMapping("/books/new")
	public String createBooks(@ModelAttribute("book") Book book) {
		return "createBook.jsp";
	}

	@PostMapping("/books")
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession sesh) {
		if (result.hasErrors()) {
			return "createBook.jsp";
		} else {
			// ********this is the programmatic way of doing more secure way**
			Long userId = (Long) sesh.getAttribute("user_id");
			User thisUser = userServ.findOne(userId);
			book.setUser(thisUser);
			// ******
			bookServ.createBook(book);
			return "redirect:/books";
		}

	}

	@GetMapping("/books/{id}")
	public String showOne(@PathVariable("id") Long id, Model model, HttpSession sesh) {
		Book thisBook = bookServ.findBook(id);
		Long userId = (Long) sesh.getAttribute("user_id");
		User thisUser = userServ.findOne(userId);
		model.addAttribute("thisUser", thisUser);
		model.addAttribute("thisBook", thisBook);
		return "showOne.jsp";
	}

	// EDIT PAGE
	@GetMapping("books/{id}/edit")
		public String updateBook(@PathVariable("id") Long id, Model model) {
//			System.out.println(id);
			Book book = bookServ.findBook(id);
	        model.addAttribute("book", book);
			return "editBook.jsp";
	}
		
		//EDIT METHOD
	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession sesh) {
		if (result.hasErrors()) {
			return "editBook.jsp";
		} else {
			Long userId = (Long) sesh.getAttribute("user_id");
			User thisUser = userServ.findOne(userId);
			book.setUser(thisUser);
			bookServ.updateBook(book);
			return "redirect:/books";
		}
	}

	// DELETE using form in index.jsp
	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}

}
