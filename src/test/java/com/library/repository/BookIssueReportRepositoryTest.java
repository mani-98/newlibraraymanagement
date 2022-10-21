package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.entity.BookIssueReportEntity;
import com.library.entity.StudentEntity;

@DataJpaTest
public class BookIssueReportRepositoryTest {
	@Autowired
	private BookIssueReportRepository bookIssueReportRepository;
	private  BookIssueReportEntity bookir;
	private  BookIssueReportEntity bookir2;
	
	@BeforeEach
	public void setup() {
		bookir=BookIssueReportEntity.builder()
				.issueDate("07 oct 2022")
				.returnDate("14 oct 2022")
				.returnDateWithoutFine("14 oct 2022")
				.fine(0)
				.build();
		bookir2=BookIssueReportEntity.builder()
				.issueDate("08 oct 2022")
				.returnDate("15 oct 2022")
				.returnDateWithoutFine("15 oct 2022")
				.fine(0)
				.build();
				
	}
	

	
	
	//bdd(behaviour driven development)= pattern-given when then
	@Test
	@DisplayName("JUnit for save bookissuereport operation...")
	public void givenBookirObject_whenSavedBookIssueReport_thenReturnSavedBookir() {
		//given-precondition or setup
			
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
				
				//verify the output
				Assertions.assertThat(savedBookir).isNotNull();
				Assertions.assertThat(savedBookir.getReportId()).isGreaterThan(0);

}
	@Test
	@DisplayName("JUnit for get all bookissuereport operation...")
	public void givenBookirList_whenFindAllBookirList_thenBookirList() {
		//given-precondition or setup
			
		bookIssueReportRepository.save(bookir);
		bookIssueReportRepository.save(bookir2);
		//when-action or behaviour that we are going to test
		
		List<BookIssueReportEntity> bookIrList=this.bookIssueReportRepository.findAll();
		//then=output
		Assertions.assertThat(bookIrList.size()).isNotNull();
		Assertions.assertThat(bookIrList.size()).isEqualTo(2);

	}
	@Test
	@DisplayName("JUnit for get bookir by id operation...")
	public void givenBookirObject_whenFindById_thenReturnedBookirObject() {
		//given-precondition or setup
	
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirById=this.bookIssueReportRepository.findById(savedBookir.getReportId()).get();
		
		//verify the output
		Assertions.assertThat(bookirById).isNotNull();
		Assertions.assertThat(bookirById.getReportId()).isGreaterThan(0);
		Assertions.assertThat(bookirById.getReportId()).isEqualTo(savedBookir.getReportId());
	
	}
	@Test
	@DisplayName("JUnit for update bookir operation...")
	public void givenBookirObject_whenUpdatedBookir_thenReturnUpdatedBookir() {
		//given-precondition or setup

		//when-action or behaviour that we are going to test
	
		
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirDB=this.bookIssueReportRepository.findById(savedBookir.getReportId()).get();
		
		bookirDB.setIssueDate("08 oct 2022");
		BookIssueReportEntity updatedBookir=bookIssueReportRepository.save(bookirDB);
		
		
		//verify the output
		Assertions.assertThat(bookirDB.getIssueDate()).isEqualTo("08 oct 2022");
		//Assertions.assertThat(studentDB.getStudentContact()).isEqualTo("9876543212");
		//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
		
	}
	
	@Test
	@DisplayName("JUnit for delete bookir operation...")
	public void givenBookirObject_whenDeletedBookir_thenDeletedSavedBookir() {
		//given-precondition or setup
//		StudentEntity student=StudentEntity.builder()
//											.studentName("xyzabcd")
//											.studentEmail("xyz@gmail.com")
//											.studentAddress("mysore456")
//											.studentContact("9876543843")
//											.studentCourse("BE")
//						                    .build();
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirDB=this.bookIssueReportRepository.findById(savedBookir.getReportId()).get();
		
		this.bookIssueReportRepository.delete(bookirDB);
		Optional<BookIssueReportEntity> bookirDB2=this.bookIssueReportRepository.findById(savedBookir.getReportId());
		
		//verify the output
		Assertions.assertThat(bookirDB2).isEmpty();	
		
	}
	
	@Test
	@DisplayName("JUnit test for customquery using jpql with index parameter...")
	public void givenReturnDateAndIssueDate_whenFindByJPQLIndex_thenReturnBookirObject() {
		//given-precondition or setup
//		
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirObj=this.bookIssueReportRepository.findByIssueDateAndReturnDateWithIndexParam(bookir.getIssueDate(),bookir.getReturnDate());
		//verify the output
		Assertions.assertThat(bookirObj).isNotNull();
		//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
		
	}
	
	@Test
	@DisplayName("JUnit test for customquery using jpql with named parameter...")
	public void givenReturnDateAndIssueDate_whenFindByJPQLNamed_thenReturnBookirObject() {
		//given-precondition or setup
//		
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirObj=this.bookIssueReportRepository.findByIssueDateAndReturnDateWithNamedParam(bookir.getIssueDate(),bookir.getReturnDate());
		//verify the output
		Assertions.assertThat(bookirObj).isNotNull();
		//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
		
	}
	@Test
	@DisplayName("JUnit test for customquery using jpql with native sql index parameter...")
	public void givenReturnDateAndIssueDate_whenFindByJPQLNativeSQLIndex_thenReturnBookirObject() {
		//given-precondition or setup
//		
		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirObj=this.bookIssueReportRepository.findByIssueDateAndReturnDateWithNativeQueryIndexParam(bookir.getIssueDate(),bookir.getReturnDate());
		//verify the output
		Assertions.assertThat(bookirObj).isNotNull();
		//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
		
	}

	@Test
	@DisplayName("JUnit test for customquery using jpql with native sql named parameter...")
	public void givenReturnDateAndIssueDate_whenFindByJPQLNativeSQLNamedParam_thenReturnBookirObject() {
		//given-precondition or setup

		//when-action or behaviour that we are going to test
		BookIssueReportEntity savedBookir=bookIssueReportRepository.save(bookir);
		BookIssueReportEntity bookirObj=this.bookIssueReportRepository.findByIssueDateAndReturnDateWithNativeQueryNamedParam(bookir.getIssueDate(),bookir.getReturnDate());
		//verify the output
		Assertions.assertThat(bookirObj).isNotNull();
		//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
		
		
	}
	
	
	

}
