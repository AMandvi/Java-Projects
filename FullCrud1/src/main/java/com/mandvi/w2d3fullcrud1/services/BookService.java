package com.mandvi.w2d3fullcrud1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mandvi.w2d3fullcrud1.models.Book;
import com.mandvi.w2d3fullcrud1.repos.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

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
	        
//	        return optionalBook.isPresent() ? optionalBook.get() : null;
	        
	        if(optionalBook.isPresent()) {
	            return optionalBook.get();
	        } else {
	            return null;
	        }
	    }
	    
	    //UPDATE
	    public Book updateBook(Book b) {
	    	Book updateBook = bookRepo.save(b);
	    	return updateBook;
	    }
	    
	    //DELETE //deleteById returns void thats why void method
	    public void deleteBook(Long id) {
	    	bookRepo.deleteById(id);
	    }
	
}
