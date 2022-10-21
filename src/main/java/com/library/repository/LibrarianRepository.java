package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.LibrarianEntity;


public interface LibrarianRepository extends JpaRepository<LibrarianEntity, Integer>{
	//jpql with index param 
	@Query("select l from LibrarianEntity l where l.librarianName=?1")
	LibrarianEntity findByLibrarianNameWithIndexParam(String librarianName);
	
	//jpql with named param
			@Query("select l from LibrarianEntity l where l.librarianName=:librarianName")
			LibrarianEntity findByLibrarianNameWithNamedParam(@Param("librarianName") String librarianName);
			
			
	//jpql with native query with index param 
	@Query(value="select  * from librarian l where l.librarian_name=?1", nativeQuery=true)
	LibrarianEntity findByLibrarianNameWithNativeQueryIndexParam(String librarianName);
			
	//jpql with named param
	@Query(value="select  * from librarian l where l.librarian_name=:librarianName",nativeQuery=true )
LibrarianEntity findByLibrarianNameWithNativeQueryNamedParam(@Param("librarianName") String librarianName);

}
