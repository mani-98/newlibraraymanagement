package com.library.serviceimplementation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BookEntity;
import com.library.entity.BookIssueReportEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.payload.BookDto;
import com.library.payload.BookIssueReportDto;
import com.library.repository.BookIssueReportRepository;
import com.library.repository.BookRepository;
import com.library.service.BookIssueReportService;



@Service
public class BookIssueReportServiceImplementation implements BookIssueReportService {
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BookIssueReportRepository bookissuereportRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public BookIssueReportDto addbookissueReport(BookIssueReportDto bookissuereport) {
		
		int bookId= bookissuereport.getBook().getBookId();
		BookEntity book= this.bookRepository.findById(bookId).orElseThrow(()->
		new ResourceNotFoundException("Book","Book Id",bookId));
		
		book.setAvailable(false);
		this.bookRepository.save(book);
		bookissuereport.setBookIssueStatus(true);
		
		
		// TODO Auto-generated method stub
		BookIssueReportEntity bookissuereportEntity=this.modelMapper.map(bookissuereport,BookIssueReportEntity.class);
		BookIssueReportEntity savedBookIssueReport=this.bookissuereportRepository.save(bookissuereportEntity);
		
		return this.modelMapper.map(savedBookIssueReport, BookIssueReportDto.class);
	}
	@Override
	public List<BookIssueReportDto> getAllBookIssueReports() {
		// TODO Auto-generated method stub
		List<BookIssueReportEntity> bookissuereportList=this.bookissuereportRepository.findAll();
		List<BookIssueReportDto> bookissuereportDtoList=bookissuereportList.stream().
											map((bookissuereport)->this.modelMapper.
													map(bookissuereport,BookIssueReportDto.class)).collect(Collectors.toList());
		return bookissuereportDtoList;
	}
	@Override
	public BookIssueReportDto getBookIssueReportById(int bookissuereportId) {
		// TODO Auto-generated method stub
		BookIssueReportEntity bookir= this.bookissuereportRepository.findById(bookissuereportId).orElseThrow(()->
		new ResourceNotFoundException("BookIssueReport","BookIssueReport Id",bookissuereportId));
	
		return this.modelMapper.map(bookir,BookIssueReportDto.class);
	}
	@Override
	public void deleteBookIssueReportById(int bookissuereportId) {
		// TODO Auto-generated method stub
		this.bookissuereportRepository.findById(bookissuereportId).orElseThrow(()->
		new ResourceNotFoundException("BookIssueReport","BookIssueReport Id",bookissuereportId));
		this.bookissuereportRepository.deleteById(bookissuereportId);
	}
	@Override
	public BookIssueReportDto updateBookIssueReport(BookIssueReportDto bookissuereport, int bookissuereportId) {
		// TODO Auto-generated method stub
		BookIssueReportEntity bookobj=this.bookissuereportRepository.findById(bookissuereportId).orElseThrow(()->
		new ResourceNotFoundException("bookissuereport", "bookissuereport id", bookissuereportId));
		bookissuereport.setReportId(bookissuereportId);
		//bookissuereport.setBookIssueStatus(true);
		BookIssueReportEntity updatebookissuereport=this.modelMapper.map(bookobj, BookIssueReportEntity.class);
		BookIssueReportEntity entity= this.bookissuereportRepository.save(updatebookissuereport);
		return this.modelMapper.map(entity, BookIssueReportDto.class);
	}
	@Override
	public BookIssueReportDto returnBookByBookId(int bookId) {
		// TODO Auto-generated method stub
		//System.out.println("*************************************************************");
		//System.out.println(this.bookissuereportRepository.getIssuesBookById(bookId,true));
		BookIssueReportEntity returnBookByBookId = this.bookissuereportRepository.getIssuesBookById(bookId,true);
		
	     returnBookByBookId.getBook().setAvailable(true);
		
		// 1. return date  2. generate fine  3. set book issue status false
    	LocalDate returnDate = LocalDate.now();//For reference
    	final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	String returndate = returnDate.format(fmt);
    	//bookissuereport.setIssueDate(formattedString);
    	//LocalDateTime dateTime = LocalDateTime.parse(returndate, formatter);
    	
    	returnBookByBookId.setReturnDate(returndate);
    	
    	
//    	System.out.println(returndate);
//    	System.out.println("this is return date");

    
    	String issueDate=returnBookByBookId.getIssueDate();
    	//LocalDate localDate = LocalDate.parse(issueDate);
 //long range = ChronoUnit.DAYS.between(returndate,issueDate );
    	long fine=0;
    	final LocalDate d1 = LocalDate.parse(returndate,fmt);
        final LocalDate d2 = LocalDate.parse(issueDate, fmt);

        final long daysInBetween = ChronoUnit.DAYS.between(d2, d1);
       // System.out.println(daysInBetween);
      if(daysInBetween>=0) {
    	  fine=daysInBetween*5;
    	  
    	  
      }
      
      returnBookByBookId.setFine((int)fine);
		
		
		
		
      returnBookByBookId.setBookIssueStatus(false);
      
        BookIssueReportEntity bookObj=   this.bookissuereportRepository.save(returnBookByBookId);
		
		return this.modelMapper.map(bookObj, BookIssueReportDto.class);
		
		
		
		}
	
	
	
	
}


	

