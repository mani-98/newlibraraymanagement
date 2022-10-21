package com.library.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDto {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookEdition;
	private String publisherName;
	private boolean isAvailable=true;
	
	
	@JsonIgnore
	List<BookIssueReportDto> bookissuereportList=new ArrayList();


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookEdition() {
		return bookEdition;
	}


	public void setBookEdition(String bookEdition) {
		this.bookEdition = bookEdition;
	}


	public String getPublisherName() {
		return publisherName;
	}


	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}


	public List<BookIssueReportDto> getBookissuereportList() {
		return bookissuereportList;
	}


	public void setBookissuereportList(List<BookIssueReportDto> bookissuereportList) {
		this.bookissuereportList = bookissuereportList;
	}


	public BookDto(int bookId, String bookName, String bookAuthor, String bookEdition, String publisherName,
			boolean isAvailable, List<BookIssueReportDto> bookissuereportList) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookEdition = bookEdition;
		this.publisherName = publisherName;
		this.isAvailable = isAvailable;
		this.bookissuereportList = bookissuereportList;
	}


	public BookDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", bookEdition="
				+ bookEdition + ", publisherName=" + publisherName + ", isAvailable=" + isAvailable
				+ ", bookissuereportList=" + bookissuereportList + "]";
	}



	

}
