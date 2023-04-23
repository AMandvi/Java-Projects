package com.mandvi.w2d3fullcrud1.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "libraries")
public class Library {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min=3,max=200, message = " name is required")
	private String name;
	
	@NotNull
	@Size(min=3,max=200, message = " location is required")
	private String location;
	
	
	//---1:M-----
	@OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
	private List <Book> books;
	
//----constructor
	public Library() {
		
	}

//----GETTERS AND SETTERS
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLocation() {
		return location;
	} 


	public void setLocation(String location) {
		this.location = location;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
