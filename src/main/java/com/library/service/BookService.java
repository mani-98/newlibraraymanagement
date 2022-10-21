package com.library.service;

import java.util.List;

import com.library.payload.BookDto;

public interface BookService {
	//add new Book
	public BookDto addbook( BookDto book);
	//add new  book
	public List< BookDto> getAllBooks(); 
	//get book by id
	public  BookDto getBookById(int bookId);
	//delete book by id
	public void deleteBookById(int bookId);
	//update 
	public  BookDto updateBook( BookDto book, int bookId);

}
