package com.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name="book")
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int bookId;
	@Column(nullable=false)
	@NotEmpty(message="Book name cannot be empty")
	private String bookName;
	@Column(nullable=false)
	@NotEmpty(message="Book Authorname cannot be empty")
	private String bookAuthor;
	@Column(nullable=false)
	@NotEmpty(message="Book edition cannot be empty")
	private String bookEdition;
	@Column(nullable=false)
	@NotEmpty(message="publisher name cannot be empty")
	private String publisherName;
	private boolean isAvailable=true;
	
//	@ManyToOne
//	
//	@JoinColumn(name="student_id")
//	private StudentEntity student;

	//@ManyToOne
//	@JoinColumn(name="report_id")
	//private BookIssueReportEntity bookissuereport;
	@JsonIgnore
	@OneToMany(mappedBy="book", cascade=CascadeType.ALL)
	 List<BookIssueReportEntity> bookissuereportlist=new ArrayList();

	
	
}
