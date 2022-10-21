package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.entity.LibrarianEntity;
import com.library.entity.StudentEntity;




@DataJpaTest
public class LibrarianRepositoryTest {
	@Autowired
	private LibrarianRepository librarianRepository;
	
	//bdd(behaviour driven development)= pattern-given when then
	
	@Test
	@DisplayName("JUnit for save librarian operation...")
	public void givenLibrarianObject_whenSavedLibrarian_thenReturnSavedLibrarian() {
		//given-precondition or setup
		LibrarianEntity librarian=LibrarianEntity.builder()
												 .librarianName("abhinav")
												 .build();
		//when-action or behaviour that we are going to test
		LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
		
		//verify the output
		Assertions.assertThat(savedLibrarian).isNotNull();
		Assertions.assertThat(savedLibrarian.getLibrarianId()).isGreaterThan(0);
	}
	

	//get all librarian list
		@Test
		@DisplayName("JUnit for get all  librarian operation...")
		public void givenLibrarianList_whenFindAllLibrarianList_thenLibrarianList() {
			LibrarianEntity librarian=LibrarianEntity.builder()
									.librarianName("abhinav")
									
									.build();
	                
//	                
//			StudentEntity student2=StudentEntity.builder()
//	                				
//									.build();
		librarianRepository.save(librarian);
//			studentRepository.save(student2);
//			
				//when-action or behaviour that we are going to test
			
			List<LibrarianEntity> librarianList=this.librarianRepository.findAll();
			//then=output
			Assertions.assertThat(librarianList.size()).isNotNull();
			Assertions.assertThat(librarianList.size()).isEqualTo(1);
		}
		
		@Test
		@DisplayName("JUnit for get librarian by id operation...")
		public void givenLibrarianObject_whenFindById_thenReturnedLibrarianObject() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
												.librarianName("abhinav")
												
							                    .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianById=this.librarianRepository.findById(savedLibrarian.getLibrarianId()).get();
			
			//verify the output
			Assertions.assertThat(librarianById).isNotNull();
			Assertions.assertThat(librarianById.getLibrarianId()).isGreaterThan(0);
			Assertions.assertThat(librarianById.getLibrarianId()).isEqualTo(savedLibrarian.getLibrarianId());
			
			
		}
		
		@Test
		@DisplayName("JUnit for update librarian operation...")
		public void givenLibrarianObject_whenUpdatedLibrarian_thenReturnUpdatedLibrarian() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
												.librarianName("abhinav")
												
							                     .build();
			//when-action or behaviour that we are going to test
		
			
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianDB=this.librarianRepository.findById(savedLibrarian.getLibrarianId()).get();
			librarianDB.setLibrarianName("abhinav gowda");
			LibrarianEntity updatedLibrarian=librarianRepository.save(librarianDB);
			
			
			//verify the output
			Assertions.assertThat(librarianDB.getLibrarianName()).isEqualTo("abhinav gowda");
			//Assertions.assertThat(studentDB.getStudentContact()).isEqualTo("9876543212");
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		
		@Test
		@DisplayName("JUnit for delete librarian operation...")
		public void givenLibrarianObject_whenDeletedLibrarian_thenDeletedSavedLibrarian() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
												.librarianName("abhinav")
												
							                    .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianDB=this.librarianRepository.findById(savedLibrarian.getLibrarianId()).get();
			this.librarianRepository.delete(librarianDB);
			Optional<LibrarianEntity> LibrarianDB=this.librarianRepository.findById(savedLibrarian.getLibrarianId());
			
			//verify the output
			Assertions.assertThat(LibrarianDB).isEmpty();
			
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with index parameter...")
		public void givenLibrarianName_whenFindByJPQLIndex_thenReturnLibrarianObject() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
											.librarianName("abhinav")
											
								            .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianObj=this.librarianRepository.findByLibrarianNameWithIndexParam(librarian.getLibrarianName());
			//verify the output
			Assertions.assertThat(librarianObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with named parameter...")
		public void givenLibrarianName_whenFindByJPQLNamed_thenReturnLibrarianObject() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
					.librarianName("abhinav")
					
		            .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianObj=this.librarianRepository.findByLibrarianNameWithNamedParam(librarian.getLibrarianName());
			//verify the output
			Assertions.assertThat(librarianObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with native sql index parameter...")
		public void givenLibrarianName_whenFindByJPQLNativeSQLIndex_thenReturnLibrarianObject() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
					.librarianName("abhinav")
					
		            .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianObj=this.librarianRepository.findByLibrarianNameWithNativeQueryIndexParam(librarian.getLibrarianName());
			//verify the output
			Assertions.assertThat(librarianObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		@Test
		@DisplayName("JUnit test for customquery using jpql with native sql named parameter...")
		public void givenLibrarianName_whenFindByJPQLNativeSQLNamedParam_thenReturnLibrarianObject() {
			//given-precondition or setup
			LibrarianEntity librarian=LibrarianEntity.builder()
											.librarianName("abhinav")
											
								            .build();
			//when-action or behaviour that we are going to test
			LibrarianEntity savedLibrarian=librarianRepository.save(librarian);
			LibrarianEntity librarianObj=this.librarianRepository.findByLibrarianNameWithNativeQueryNamedParam(librarian.getLibrarianName());
			//verify the output
			Assertions.assertThat(librarianObj).isNotNull();
			//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
			
			
		}
		
		
}
