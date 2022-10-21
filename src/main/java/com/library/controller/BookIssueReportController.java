package com.library.controller;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.print.attribute.standard.Chromaticity;
import javax.validation.Valid;
import java.time.temporal.ChronoUnit;

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
import com.library.payload.BookIssueReportDto;
import com.library.payload.StudentDto;
import com.library.service.BookIssueReportService;

@RestController
@RequestMapping("/bookissuereport")
public class BookIssueReportController {
	@Autowired
	private BookIssueReportService bookissuereportService;
	
	//ADD bookissuereport method
    @PostMapping("/")  
    public BookIssueReportDto addBookIssueReport( @RequestBody BookIssueReportDto bookissuereport)
    		                                   
    {
    	//StudentDto newStudent= this.studentService.addStudent(student);
    	
    	//String date = bookissuereport.getIssueDate(); 
    	//Date currentDate = new Date();
    	LocalDate localDate = LocalDate.now();//For reference
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
    	String formattedString1 = localDate.format(formatter);

    	bookissuereport.setIssueDate(formattedString1);
    
    	 DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
     	  // String date = "03 Feb 2017";
     	   LocalDate localDate1 = LocalDate.parse(formattedString1, dateTimeFormatter);
     	 LocalDate returnvalue= localDate1.plusDays(5);
//     	LocalDate tod = LocalDate.now();
     	 
     	String formattedDate = returnvalue.format(DateTimeFormatter.ofPattern("dd LLLL yyyy"));
//     	  System.out.println(returnvalue);
    	bookissuereport.setReturnDateWithoutFine(formattedDate);
    	
    	
    	
    	return this.bookissuereportService.addbookissueReport(bookissuereport);
    }
    
    //get book by Id method
    @GetMapping("/{bookissuereportId}") // mapping handler
    public ResponseEntity<BookIssueReportDto> getBookIssueReportById(@PathVariable("bookissuereportId") int bookissuereportId)
    {
    	BookIssueReportDto bookissuereport=this.bookissuereportService.getBookIssueReportById(bookissuereportId);
		
    	return new ResponseEntity<BookIssueReportDto>(bookissuereport,HttpStatus.OK);
    	
    }
    
    @GetMapping("/")
    public ResponseEntity<List<BookIssueReportDto>> getAllBookIssueReports()
    {
    	List<BookIssueReportDto> getallBookIssueReports = this.bookissuereportService.getAllBookIssueReports();
    	return new ResponseEntity<List<BookIssueReportDto>>(getallBookIssueReports,HttpStatus.OK);
    }
    @DeleteMapping("{bookissuereportId}")
    public ResponseEntity<ApiResponse> deleteBookIssueReportById(@PathVariable("bookissuereportId") int bookissuereportId)
    {
    	this.bookissuereportService.deleteBookIssueReportById(bookissuereportId);
    	ApiResponse response=new ApiResponse("bookissuereport record is deleted",true);
    	return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
    }
    
    @PutMapping("/{bookissuereportId}")
   	public ResponseEntity<BookIssueReportDto> updateBookIssueReport( @RequestBody BookIssueReportDto bookissuereport,@PathVariable("bookissuereportId") int bookissuereportId)
   	{
   		BookIssueReportDto updateBookIssueReport = this.bookissuereportService.updateBookIssueReport(bookissuereport, bookissuereportId);
   		return new ResponseEntity<BookIssueReportDto>(updateBookIssueReport,HttpStatus.OK);
   	}
   
    @GetMapping("/returnbook/{bookId}")
    public  ResponseEntity<BookIssueReportDto> returnBookByBookId(@PathVariable("bookId") int bookid)
    {
    	
    	BookIssueReportDto returnBookByBookId=this.bookissuereportService.returnBookByBookId(bookid);
    	
    
    		
		return new ResponseEntity<BookIssueReportDto>(returnBookByBookId,HttpStatus.OK);
    }	
    
   
    

}
