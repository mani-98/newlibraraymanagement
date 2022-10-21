package com.library.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.library.entity.BookEntity;
import com.library.entity.BookIssueReportEntity;
import com.library.entity.LibrarianEntity;


public class StudentDto {
	private int studentId;
	private String studentName;
	private String studentEmail;
	private String studentAddress;
	private String studentContact;
	private String studentCourse;
	
	private LibrarianEntity librarian;
	
	//private BookIssueReportEntity bookissuereport;
	@JsonIgnore
	List<BookIssueReportDto> bookissuereportList=new ArrayList();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public String getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}

	public String getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(String studentCourse) {
		this.studentCourse = studentCourse;
	}

	public LibrarianEntity getLibrarian() {
		return librarian;
	}

	public void setLibrarian(LibrarianEntity librarian) {
		this.librarian = librarian;
	}

	public List<BookIssueReportDto> getBookissuereportList() {
		return bookissuereportList;
	}

	public void setBookissuereportList(List<BookIssueReportDto> bookissuereportList) {
		this.bookissuereportList = bookissuereportList;
	}

	public StudentDto(int studentId, String studentName, String studentEmail, String studentAddress,
			String studentContact, String studentCourse, LibrarianEntity librarian,
			List<BookIssueReportDto> bookissuereportList) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentContact = studentContact;
		this.studentCourse = studentCourse;
		this.librarian = librarian;
		this.bookissuereportList = bookissuereportList;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentDto [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentAddress=" + studentAddress + ", studentContact=" + studentContact + ", studentCourse="
				+ studentCourse + ", librarian=" + librarian + ", bookissuereportList=" + bookissuereportList + "]";
	}

	

	
	
	
	
	
	
}
