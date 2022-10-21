package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	//jpql with index param 
			@Query("select s from StudentEntity s where s.studentName=?1 and s.studentEmail=?2 ")
			StudentEntity findByStudentNameAndEmailWithIndexParam(String studentName,String studentEmail);
			
			//jpql with named param
					@Query("select s from StudentEntity s where s.studentName=:studentName and s.studentEmail=:studentEmail ")
					StudentEntity findByStudentNameAndEmailWithNamedParam(@Param("studentName") String studentName,@Param("studentEmail") String studentEmail);
					
					
			//jpql with native query with index param 
			@Query(value="select  * from student s where s.student_name=?1 and s.student_email=?2", nativeQuery=true)
			StudentEntity findByStudentNameAndEmailWithNativeQueryIndexParam(String studentName,String studentEmail);
					
			//jpql with named param
			@Query(value="select  * from student s where s.student_name=:studentName and s.student_email=:studentEmail", nativeQuery=true )
			StudentEntity findByStudentNameAndEmailWithNativeQueryNamedParam(@Param("studentName") String studentName,@Param("studentEmail") String studentEmail);
					
			

}
