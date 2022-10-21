package com.library.service;

import java.util.List;

import com.library.payload.LibrarianDto;

public interface LibrarianService {

	//add new  Librarian
			public LibrarianDto addlibrarian( LibrarianDto librarian);
			//add new  Librarian
			public List< LibrarianDto> getAllLibrarians(); 
			//get student by id
			public  LibrarianDto getLibrarianById(int librarianId);
			//delete student by id
			public void deleteLibrarianById(int librarianId);
			//update 
			public  LibrarianDto updateLibrarian( LibrarianDto librarian, int librarianId);
		

}
