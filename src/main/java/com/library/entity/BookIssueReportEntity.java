package com.library.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="bookissuereport")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookIssueReportEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int reportId;
	@Column(nullable=false)
	private String issueDate;
	@Column(nullable=false)
	private String returnDate;
	@Column(nullable=false)
	private String returnDateWithoutFine;
	@Column(nullable=false)
	public boolean bookIssueStatus=false;
	@Column(nullable=false)
	private int fine;
	
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private BookEntity book;
	
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private StudentEntity student;


	


	

	
	
	

}
