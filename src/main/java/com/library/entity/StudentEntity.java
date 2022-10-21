package com.library.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	@Column(nullable=false)
	@NotEmpty(message="student name cannot be empty")
	@Size(min=5,max=10,message="name should be min 5 character and max 10")
	private String studentName;
	@Column(nullable=false)
	@Email
	@NotEmpty(message="student email cannot be empty")
	@Pattern(message="invalid Email Id",regexp="[a-z0-9]+@gmail.com")
	private String studentEmail;
	@Column(nullable=false)
	@NotEmpty(message="student address cannot be empty")
	@Size(min=8,max=20,message="address should be min 8 character and max 20")
	private String studentAddress;
	@Column(nullable=false)
	@NotEmpty(message="student contact  cannot be empty")
	@Size(min=10,max=10,message="number should be min 10 character and max 10")
	private String studentContact;
	@Column(nullable=false)
	private String studentCourse;
	
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name="librarian_id")
	private LibrarianEntity librarian;
	
	
	//@JoinColumn(name="report_id")
	
 
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "student")
	
	@JsonIgnore
	private List<BookIssueReportEntity> bookissuereport = new ArrayList<>();

	
	
	

}
