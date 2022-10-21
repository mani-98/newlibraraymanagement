package com.library.repository;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.library.entity.BookEntity;
import com.library.entity.StudentEntity;



@DataJpaTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;
	private BookEntity book;
	private BookEntity book2;
	
//	
	@BeforeEach
	public void setup() {
		book=BookEntity.builder()
				.bookName("java")
				.bookAuthor("reddy")
				.bookEdition("first")
				.publisherName("chandan publicatons")
				.build();
		book2=BookEntity.builder()
				.bookName("python")
				.bookAuthor("teddy")
				.bookEdition("second")
				.publisherName("chethan publicatons")
				.build();	
		
		
	}
	
	//bdd(behaviour driven development)= pattern-given when then
	@Test
	@DisplayName("JUnit for save book operation...")
	public void givenBookObject_whenSavedBook_thenReturnSavedBook() {
		//given-precondition or setup

		//when-action or behaviour that we are going to test
		BookEntity savedBook=bookRepository.save(book);
		
		//verify the output
		Assertions.assertThat(savedBook).isNotNull();
		Assertions.assertThat(savedBook.getBookId()).isGreaterThan(0);
}
	//get all book list
			@Test
			@DisplayName("JUnit for get all  book operation...")
			public void givenBookList_whenFindAllBookList_thenBookList() {
			
				bookRepository.save(book);
				bookRepository.save(book2);
				
					//when-action or behaviour that we are going to test
				
				List<BookEntity> bookList=this.bookRepository.findAll();
				//then=output
				Assertions.assertThat(bookList.size()).isNotNull();
				Assertions.assertThat(bookList.size()).isEqualTo(2);
			}
			@Test
			@DisplayName("JUnit for get book by id operation...")
			public void givenBookObject_whenFindById_thenReturnedBookObject() {
				//given-precondition or setup
						
								                 
				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookById=this.bookRepository.findById(savedBook.getBookId()).get();
				
				//verify the output
				Assertions.assertThat(bookById).isNotNull();
				Assertions.assertThat(bookById.getBookId()).isGreaterThan(0);
				Assertions.assertThat(bookById.getBookId()).isEqualTo(savedBook.getBookId());
				
				
			}
			
			@Test
			@DisplayName("JUnit for update book operation...")
			public void givenBookObject_whenUpdatedBook_thenReturnUpdatedBook() {
				//given-precondition or setup
					
													
				//when-action or behaviour that we are going to test
			
				
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookDB=this.bookRepository.findById(savedBook.getBookId()).get();
				bookDB.setBookAuthor("reddy varda");
				BookEntity updatedBook=bookRepository.save(bookDB);
				
				
				//verify the output
				Assertions.assertThat(bookDB.getBookAuthor()).isEqualTo("reddy varda");
				//Assertions.assertThat(studentDB.getStudentContact()).isEqualTo("9876543212");
				//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
				
				
			}
			
			@Test
			@DisplayName("JUnit for delete book operation...")
			public void givenBookObject_whenDeletedBook_thenDeletedSavedBook() {
				//given-precondition or setup
//				BookEntity book=BookEntity.builder()
//													.bookName("java")
//													.bookAuthor("reddy")
//													.bookEdition("first")
//													.publisherName("chandan publicatons")
//													
//								                    .build();
				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity BookDB=this.bookRepository.findById(savedBook.getBookId()).get();
				this.bookRepository.delete(BookDB);
				Optional<BookEntity> bookDB2=this.bookRepository.findById(savedBook.getBookId());
				
				//verify the output
				Assertions.assertThat(bookDB2).isEmpty();
				
				
				
			}
			
			
			@Test
			@DisplayName("JUnit test for customquery using jpql with index parameter...")
			public void givenBookNameAndBookAuthor_whenFindByJPQLIndex_thenReturnBookObject() {
				//given-precondition or setup
//				
				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookObj=this.bookRepository.findByBookNameAndAuthorWithIndexParam(book.getBookName(),book.getBookAuthor());
				//verify the output
				Assertions.assertThat(bookObj).isNotNull();
				//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
				
				
			}
			@Test
			@DisplayName("JUnit test for customquery using jpql with named parameter...")
			public void givenBookNameAndBookAuthor_whenFindByJPQLNamed_thenReturnBookObject() {
				//given-precondition or setup
//				
				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookObj=this.bookRepository.findByBookNameAndAuthorWithNamedParam(book.getBookName(),book.getBookAuthor());
				//verify the output
				Assertions.assertThat(bookObj).isNotNull();
				//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
				
				
			}
			@Test
			@DisplayName("JUnit test for customquery using jpql with native sql index parameter...")
			public void givenBookNameAndBookAuthor_whenFindByJPQLNativeSQLIndex_thenReturnBookObject() {
				//given-precondition or setup
//				
				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookObj=this.bookRepository.findByBookNameAndAuthorWithNativeQueryIndexParam(book.getBookName(),book.getBookAuthor());
				//verify the output
				Assertions.assertThat(bookObj).isNotNull();
				//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
				
				
			}
			@Test
			@DisplayName("JUnit test for customquery using jpql with native sql named parameter...")
			public void givenBookNameAndBookAuthor_whenFindByJPQLNativeSQLNamedParam_thenReturnBookObject() {
				//given-precondition or setup

				//when-action or behaviour that we are going to test
				BookEntity savedBook=bookRepository.save(book);
				BookEntity bookObj=this.bookRepository.findByBookNameAndAuthorWithNativeQueryNamedParam(book.getBookName(),book.getBookAuthor());
				//verify the output
				Assertions.assertThat(bookObj).isNotNull();
				//Assertions.assertThat(savedStudent.getStudentId()).isGreaterThan(0);
				
				
			}
}
