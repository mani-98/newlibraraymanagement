package com.library.service;

import java.util.List;

import com.library.payload.StudentDto;

public interface StudentService {
	//add new student
		public StudentDto addStudent(StudentDto student);
		//add new student
		public List<StudentDto> getAllStudents(); 
		//get student by id
		public StudentDto getStudentById(int studentId);
		//delete student by id
		public void deleteStudentById(int studentId);
		//update 
		public StudentDto updateStudent(StudentDto student, int studentId);
	

}
