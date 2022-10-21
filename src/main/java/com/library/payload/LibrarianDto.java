package com.library.payload;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

public class LibrarianDto {
	private int librarianId;
	private String librarianName;
	
	
	@JsonIgnore
	List<StudentDto> studentList=new ArrayList();


	public int getLibrarianId() {
		return librarianId;
	}


	public void setLibrarianId(int librarianId) {
		this.librarianId = librarianId;
	}


	public String getLibrarianName() {
		return librarianName;
	}


	public void setLibrarianName(String librarianName) {
		this.librarianName = librarianName;
	}


	public List<StudentDto> getStudentList() {
		return studentList;
	}


	public void setStudentList(List<StudentDto> studentList) {
		this.studentList = studentList;
	}


	public LibrarianDto(int librarianId, String librarianName, List<StudentDto> studentList) {
		super();
		this.librarianId = librarianId;
		this.librarianName = librarianName;
		this.studentList = studentList;
	}


	public LibrarianDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "LibrarianDto [librarianId=" + librarianId + ", librarianName=" + librarianName + ", studentList="
				+ studentList + "]";
	}


	



	

}
