package com.library.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BookEntity;
import com.library.entity.LibrarianEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.payload.BookDto;
import com.library.payload.LibrarianDto;
import com.library.repository.BookRepository;
import com.library.service.BookService;
@Service
public class BookServiceImplementation implements BookService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BookDto addbook(BookDto book) {
		// TODO Auto-generated method stub
		BookEntity bookEntity=this.modelMapper.map(book,BookEntity.class);
		BookEntity savedBook=this.bookRepository.save(bookEntity);
		
		return this.modelMapper.map(savedBook, BookDto.class);
	}

	@Override
	public List<BookDto> getAllBooks() {
		// TODO Auto-generated method stub
		List<BookEntity> bookList=this.bookRepository.findAll();
		List<BookDto> bookDtoList=bookList.stream().
											map((book)->this.modelMapper.
													map(book,BookDto.class)).collect(Collectors.toList());
		return bookDtoList;
	}

	@Override
	public BookDto getBookById(int bookId) {
		// TODO Auto-generated method stub
		BookEntity book= this.bookRepository.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("Book","Book Id",bookId));
		return this.modelMapper.map(book,BookDto.class);
	}

	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		this.bookRepository.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("Book","Book Id",bookId));
		this.bookRepository.deleteById(bookId);
	}

	@Override
	public BookDto updateBook(BookDto book, int bookId) {
		// TODO Auto-generated method stub
		BookEntity bookobj=this.bookRepository.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("book", "book id", bookId));
		book.setBookId(bookId);
		BookEntity updatebook=this.modelMapper.map(book, BookEntity.class);
		BookEntity entity= this.bookRepository.save(updatebook);
		return this.modelMapper.map(entity, BookDto.class);
	}

}
