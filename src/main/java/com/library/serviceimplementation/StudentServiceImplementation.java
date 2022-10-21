package com.library.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BookEntity;
import com.library.entity.StudentEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.payload.BookDto;
import com.library.payload.StudentDto;
import com.library.repository.StudentRepository;
import com.library.service.StudentService;
@Service
public class StudentServiceImplementation implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StudentDto addStudent(StudentDto studentDto) {
		StudentEntity studentEntity=this.modelMapper.map(studentDto,StudentEntity.class);
		StudentEntity savedStudent=this.studentRepository.save(studentEntity);
		
		return this.modelMapper.map(savedStudent, StudentDto.class);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentDto> getAllStudents() {
		// TODO Auto-generated method stub
		List<StudentEntity> studentList=this.studentRepository.findAll();
		List<StudentDto> studentDtoList=studentList.stream().
											map((student)->this.modelMapper.
													map(student,StudentDto.class)).collect(Collectors.toList());
		return studentDtoList;
	}
	@Override
	public StudentDto getStudentById(int studentId) {
		StudentEntity student= this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("Student","Student Id",studentId));
		return this.modelMapper.map(student,StudentDto.class);
	}

	@Override
	public void deleteStudentById(int studentId) {
		// TODO Auto-generated method stub
		this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("Student","Student Id",studentId));
		this.studentRepository.deleteById(studentId);

		
	}
	
//	@Override
//	public StudentDto updateStudent(StudentDto student, int studentId) {
//		StudentEntity studentobj= this.studentRepository.findById(studentId).orElseThrow(() ->
//			new ResourceNotFoundException("Student","Student Id",studentId));
//			
//			StudentEntity updatedStudent=this.modelMapper.map(studentobj, StudentEntity.class);
//			return this.modelMapper.map(student,StudentDto.class);
//	}
	public StudentDto updateStudent(StudentDto student, int studentId) {
		StudentEntity studentobj=this.studentRepository.findById(studentId).orElseThrow(()->
		new ResourceNotFoundException("student", "student id", studentId));
//		student.setStudentId(studentId);
		student.setStudentId(studentId);
		StudentEntity updatestudent=this.modelMapper.map(student, StudentEntity.class);
		StudentEntity entity= this.studentRepository.save(updatestudent);
		return this.modelMapper.map(entity, StudentDto.class);
		
	}
}
