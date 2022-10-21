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
import com.library.payload.StudentDto;
import com.library.service.StudentService;
@RestController
@RequestMapping("/student")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	//ADD student method
    @PostMapping("/")
    public StudentDto addStudent(@Valid @RequestBody StudentDto student)
    {
    	//StudentDto newStudent= this.studentService.addStudent(student);
    	return this.studentService.addStudent(student);
    }
 // get Student by Id method
    @GetMapping("/{studentId}") // mapping handler
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId") int studentId)
    {
    	StudentDto student=this.studentService.getStudentById(studentId);
		
    	return new ResponseEntity<StudentDto>(student,HttpStatus.OK);
    	
    }
    
    // get All Student method
    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudents()
    {
    	List<StudentDto> getallStudents = this.studentService.getAllStudents();
    	return new ResponseEntity<List<StudentDto>>(getallStudents,HttpStatus.OK);
    }
    
    @DeleteMapping("{studentId}")
    public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable("studentId") int studentId)
    {
    	this.studentService.deleteStudentById(studentId);
    	ApiResponse response=new ApiResponse("student record is deleted",true);
    	return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
    }
    @PutMapping("/{studentId}")
	public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto student,@PathVariable("studentId") int studentId)
	{
		StudentDto updateStudent = this.studentService.updateStudent(student, studentId);
		return new ResponseEntity<StudentDto>(updateStudent,HttpStatus.OK);
	}
//    
}