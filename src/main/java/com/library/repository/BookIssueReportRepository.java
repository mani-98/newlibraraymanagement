package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.BookIssueReportEntity;


public interface BookIssueReportRepository extends JpaRepository<BookIssueReportEntity, Integer>{
	
	
	@Query(value="Select * from bookissuereport b where b.book_id=:bookId and b.book_issue_status=:status",nativeQuery=true)
	public BookIssueReportEntity getIssuesBookById(@Param("bookId") int bookId,@Param("status") boolean status);
	
	@Query("select br from BookIssueReportEntity br where br.issueDate=?1 and br.returnDate=?2 ")
	BookIssueReportEntity findByIssueDateAndReturnDateWithIndexParam(String issueDate,String returnDate);
	
	//jpql with named param
			@Query("select br from BookIssueReportEntity br where br.issueDate=:issueDate and br.returnDate=:returnDate ")
			BookIssueReportEntity findByIssueDateAndReturnDateWithNamedParam(@Param("issueDate") String issueDate,@Param("returnDate") String returnDate);
			
			
	//jpql with native query with index param 
	@Query(value="select  * from bookissuereport br where br.issue_date=?1 and br.return_date=?2",nativeQuery=true)
	BookIssueReportEntity findByIssueDateAndReturnDateWithNativeQueryIndexParam(String issueDate,String returnDate);
			
	//jpql with named param
	@Query(value="select  * from bookissuereport br where br.issue_date=:issueDate and br.return_date=:returnDate",nativeQuery=true )
	BookIssueReportEntity findByIssueDateAndReturnDateWithNativeQueryNamedParam(@Param("issueDate") String issueDate,@Param("returnDate") String returnDate);
		
//	

}
