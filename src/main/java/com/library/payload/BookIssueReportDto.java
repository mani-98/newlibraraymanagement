package com.library.payload;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.library.entity.StudentEntity;

public class BookIssueReportDto {
	private int reportId;
	private String issueDate;
	private String returnDate;
	private String returnDateWithoutFine;
	private int fine;
	public boolean bookIssueStatus=false;
	
	private BookDto book  ;
	
	private StudentDto student;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnDateWithoutFine() {
		return returnDateWithoutFine;
	}

	public void setReturnDateWithoutFine(String returnDateWithoutFine) {
		this.returnDateWithoutFine = returnDateWithoutFine;
	}

	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public boolean isBookIssueStatus() {
		return bookIssueStatus;
	}

	public void setBookIssueStatus(boolean bookIssueStatus) {
		this.bookIssueStatus = bookIssueStatus;
	}

	public BookDto getBook() {
		return book;
	}

	public void setBook(BookDto book) {
		this.book = book;
	}

	public StudentDto getStudent() {
		return student;
	}

	public void setStudent(StudentDto student) {
		this.student = student;
	}

	public BookIssueReportDto(int reportId, String issueDate, String returnDate, String returnDateWithoutFine, int fine,
			boolean bookIssueStatus, BookDto book, StudentDto student) {
		super();
		this.reportId = reportId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.returnDateWithoutFine = returnDateWithoutFine;
		this.fine = fine;
		this.bookIssueStatus = bookIssueStatus;
		this.book = book;
		this.student = student;
	}

	public BookIssueReportDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookIssueReportDto [reportId=" + reportId + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", returnDateWithoutFine=" + returnDateWithoutFine + ", fine=" + fine + ", bookIssueStatus="
				+ bookIssueStatus + ", book=" + book + ", student=" + student + "]";
	}

	

}
