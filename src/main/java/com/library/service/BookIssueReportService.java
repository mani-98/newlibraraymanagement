package com.library.service;

import java.util.List;


import com.library.payload.BookIssueReportDto;

public interface BookIssueReportService {
	//add new Bookissuereport
		public BookIssueReportDto addbookissueReport( BookIssueReportDto bookissuereport);
		//add new  book
		public List<BookIssueReportDto> getAllBookIssueReports(); 
		//get book by id
		public  BookIssueReportDto getBookIssueReportById(int bookissuereportId);
		//delete book by id
		public void deleteBookIssueReportById(int bookissuereportId);
		//update 
		public  BookIssueReportDto updateBookIssueReport( BookIssueReportDto bookissuereport, int bookissuereportId);
		
		public BookIssueReportDto returnBookByBookId(int bookId);
}
