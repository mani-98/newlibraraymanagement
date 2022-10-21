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
@Table(name="librarian")
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LibrarianEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int librarianId;
	@Column(nullable=false)
	@NotEmpty(message="librarian name cannot be empty")
	private String librarianName;
	
	
	@OneToMany(mappedBy="librarian", cascade=CascadeType.ALL)
	@JsonIgnore
	 List<StudentEntity> studentlist=new ArrayList();


	
	

	
	
	
	
	

}
