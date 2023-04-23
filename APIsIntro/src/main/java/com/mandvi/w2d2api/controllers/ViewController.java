package com.mandvi.w2d2api.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mandvi.w2d2api.models.Book;
import com.mandvi.w2d2api.services.BookService;

@Controller
public class ViewController {
	private final BookService bookService;

	public ViewController(BookService bookService) {
        this.bookService = bookService;
	}
	@GetMapping("/")
	public String allBooks(Model model) {
		List<Book> allDaBooks = bookService.allBooks();
		System.out.println(allDaBooks);
		
		//lets send the books in the page
		model.addAttribute("allDaBooks",allDaBooks);
		return "books.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/books")
	public String create(
	    @RequestParam("title") String title,
	    @RequestParam("description") String description,
	    @RequestParam("language") String language,
	    @RequestParam("pages") Integer pages) 
	{
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	    Book book = new Book(title, description, language, pages);
	    bookService.createBook(book);
	    return "redirect:/";
	}


	
	
}