package com.mandvi.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.bookclub.models.Book;
import com.mandvi.bookclub.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepo;

	// ======FULL CRUD ======

	// READ ALL
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}

	// CREATE
	public Book createBook(Book b) {
		return bookRepo.save(b);
	}

	// READ ONE
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);

		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

	// UPDATE
	public Book updateBook(Book b) {
		Book updateBook = bookRepo.save(b);
		return updateBook;
	}

	// DELETE //deleteById returns void thats why void method
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}

}
