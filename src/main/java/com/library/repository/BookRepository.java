package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.BookEntity;


public interface BookRepository extends JpaRepository<BookEntity, Integer> {
	//jpql with index param 
	@Query("select b from BookEntity b where b.bookName=?1 and b.bookAuthor=?2 ")
	BookEntity findByBookNameAndAuthorWithIndexParam(String bookName,String bookAuthor);
	
	//jpql with named param
			@Query("select b from BookEntity b where b.bookName=:bookName and b.bookAuthor=:bookAuthor ")
			BookEntity findByBookNameAndAuthorWithNamedParam(@Param("bookName") String bookName,@Param("bookAuthor") String bookAuthor );
			
			
	//jpql with native query with index param 
	@Query(value="select  * from book b where b.book_name=?1 and b.book_author=?2",nativeQuery=true)
	BookEntity findByBookNameAndAuthorWithNativeQueryIndexParam(String bookName,String bookAuthor);
			
	//jpql with named param
	@Query(value="select  * from book b where b.book_name=:bookName and b.book_author=:bookAuthor", nativeQuery=true )
	BookEntity findByBookNameAndAuthorWithNativeQueryNamedParam(@Param("bookName") String bookName,@Param("bookAuthor") String bookAuthor);
	

}
