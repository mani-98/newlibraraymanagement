package com.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.ApiResponse;
import com.library.payload.BookDto;
import com.library.payload.LibrarianDto;
import com.library.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//ADD book method
    @PostMapping("/")
    public BookDto addBook(@Valid @RequestBody BookDto book)
    {
    	//StudentDto newStudent= this.studentService.addStudent(student);
    	return this.bookService.addbook(book);
    }
    //get book by Id method
    @GetMapping("/{bookId}") // mapping handler
    public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") int bookId)
    {
    	BookDto book=this.bookService.getBookById(bookId);
		
    	return new ResponseEntity<BookDto>(book,HttpStatus.OK);
    	
    }
    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getAllBooks()
    {
    	List<BookDto> getallBooks = this.bookService.getAllBooks();
    	return new ResponseEntity<List<BookDto>>(getallBooks,HttpStatus.OK);
    }
    @DeleteMapping("{bookId}")
    public ResponseEntity<ApiResponse> deleteBookById(@PathVariable("bookId") int bookId)
    {
    	this.bookService.deleteBookById(bookId);
    	ApiResponse response=new ApiResponse("book record is deleted",true);
    	return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
    }
    @PutMapping("/{bookId}")
	public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto book,@PathVariable("bookId") int bookId)
	{
		BookDto updateBook = this.bookService.updateBook(book, bookId);
		return new ResponseEntity<BookDto>(updateBook,HttpStatus.OK);
	}

}
