package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.entity.StudentEntity;



@DataJpaTest
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	private StudentEntity student;
	private StudentEntity student2;
	
//	
	@BeforeEach
	public void setup() {
		student=StudentEntity.builder()
				.studentName("abcdefddd")
				.studentEmail("abcd@gmail.com")
				.studentAddress("mandya1234")
				.studentContact("9876543212")
				.studentCourse("BE")
              
                .build();
		student2=StudentEntity.builder()
				.studentName("xyzabcd")
				.studentEmail("xyz@gmail.com")
				.studentAddress("mysore456")
				.studentContact("9876543843")
				.studentCourse("BE")
				.build();
	}
	
	//bdd(behaviour driven development)= pattern-given when then
	@Test
	@DisplayName("JUnit for save student operation...")
	public void givenStudentObject_whenSavedStudent_thenReturnSavedStudent() {
		//given-precondition or setup
//	
		//when-action or behaviour that we are going to test
				StudentEntity savedStudent=studentRepository.save(student);
				
				//verify the output
				Assertions.assertThat(savedStudent).isNotNull();
				Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);

}
	//get all student list
		@Test
		@DisplayName("JUnit for get all  student operation...")
		public void givenStudentList_whenFindAllStudentList_thenStudentList() {
		
	
			studentRepository.save(student);
			studentRepository.save(student2);
			
				//when-action or behaviour that we are going to test
			
			List<StudentEntity> studentList=this.studentRepository.findAll();
			//then=output
			Assertions.assertThat(studentList.size()).isNotNull();
			Assertions.assertThat(studentList.size()).isEqualTo(2);
		}
		
		@Test
		@DisplayName("JUnit for get student by id operation...")
		public void givenStudentObject_whenFindById_thenReturnedStudentObject() {
			//given-precondition or setup
		
			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentById=this.studentRepository.findById(savedStudent.getStudentId()).get();
			
			//verify the output
			Assertions.assertThat(studentById).isNotNull();
			Assertions.assertThat(studentById.getStudentId()).isGreaterThan(0);
			Assertions.assertThat(studentById.getStudentId()).isEqualTo(savedStudent.getStudentId());
			
			
		}
		
		@Test
		@DisplayName("JUnit for update student operation...")
		public void givenStudentObject_whenUpdatedStudent_thenReturnUpdatedStudent() {
			//given-precondition or setup

			//when-action or behaviour that we are going to test
		
			
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentDB=this.studentRepository.findById(savedStudent.getStudentId()).get();
			studentDB.setStudentEmail("dc@gmail.com");
			StudentEntity updatedStudent=studentRepository.save(studentDB);
			
			
			//verify the output
			Assertions.assertThat(studentDB.getStudentEmail()).isEqualTo("dc@gmail.com");
			//Assertions.assertThat(studentDB.getStudentContact()).isEqualTo("9876543212");
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		
		@Test
		@DisplayName("JUnit for delete student operation...")
		public void givenStudentObject_whenDeletedStudent_thenDeletedSavedStudent() {
			//given-precondition or setup
//			StudentEntity student=StudentEntity.builder()
//												.studentName("xyzabcd")
//												.studentEmail("xyz@gmail.com")
//												.studentAddress("mysore456")
//												.studentContact("9876543843")
//												.studentCourse("BE")
//							                    .build();
			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentDB=this.studentRepository.findById(savedStudent.getStudentId()).get();
			this.studentRepository.delete(studentDB);
			Optional<StudentEntity> studentDB2=this.studentRepository.findById(savedStudent.getStudentId());
			
			//verify the output
			Assertions.assertThat(studentDB2).isEmpty();
			
			
			
		}
		
		@Test
		@DisplayName("JUnit test for customquery using jpql with index parameter...")
		public void givenStudentNameAndStudentEmail_whenFindByJPQLIndex_thenReturnStudentObject() {
			//given-precondition or setup
//			
			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentObj=this.studentRepository.findByStudentNameAndEmailWithIndexParam(student.getStudentName(),student.getStudentEmail());
			//verify the output
			Assertions.assertThat(studentObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with named parameter...")
		public void givenStudentNameAndStudentEmail_whenFindByJPQLNamed_thenReturnStudentObject() {
			//given-precondition or setup
//			
			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentObj=this.studentRepository.findByStudentNameAndEmailWithNamedParam(student.getStudentName(),student.getStudentEmail());
			//verify the output
			Assertions.assertThat(studentObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with native sql index parameter...")
		public void givenStudentNameAndStudentEmail_whenFindByJPQLNativeSQLIndex_thenReturnStudentObject() {
			//given-precondition or setup
//			
			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentObj=this.studentRepository.findByStudentNameAndEmailWithNativeQueryIndexParam(student.getStudentName(),student.getStudentEmail());
			//verify the output
			Assertions.assertThat(studentObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with native sql named parameter...")
		public void givenStudentNameAndStudentEmail_whenFindByJPQLNativeSQLNamedParam_thenReturnStudentObject() {
			//given-precondition or setup

			//when-action or behaviour that we are going to test
			StudentEntity savedStudent=studentRepository.save(student);
			StudentEntity studentObj=this.studentRepository.findByStudentNameAndEmailWithNativeQueryNamedParam(student.getStudentName(),student.getStudentEmail());
			//verify the output
			Assertions.assertThat(studentObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		
}
