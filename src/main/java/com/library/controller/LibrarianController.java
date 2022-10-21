package com.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.exception.ApiResponse;
import com.library.payload.LibrarianDto;
import com.library.payload.StudentDto;
import com.library.service.LibrarianService;



@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
	private LibrarianService librarianService;
	
	//ADD student method
    @PostMapping("/")
    public LibrarianDto addLibrarian(@Valid @RequestBody LibrarianDto librarian)
    {
    	//StudentDto newStudent= this.studentService.addStudent(student);
    	return this.librarianService.addlibrarian(librarian);
    }
 // get Student by Id method
    @GetMapping("/{librarianId}") // mapping handler
    public ResponseEntity<LibrarianDto> getLibrarianById(@PathVariable("librarianId") int librarianId)
    {
    	LibrarianDto student=this.librarianService.getLibrarianById(librarianId);
		
    	return new ResponseEntity<LibrarianDto>(student,HttpStatus.OK);
    	
    }
    @GetMapping("/")
    public ResponseEntity<List<LibrarianDto>> getAllLibrarian()
    {
    	List<LibrarianDto> getallLibrarian = this.librarianService.getAllLibrarians();
    	return new ResponseEntity<List<LibrarianDto>>(getallLibrarian,HttpStatus.OK);
    }
    @DeleteMapping("{librarianId}")
    public ResponseEntity<ApiResponse> deleteLibrarianById(@PathVariable("librarianId") int librarianId)
    {
    	this.librarianService.deleteLibrarianById(librarianId);
    	ApiResponse response=new ApiResponse("librarian record is deleted",true);
    	return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
    }
    @PutMapping("/{librarianId}")
	public ResponseEntity<LibrarianDto> updateLibrarian(@Valid @RequestBody LibrarianDto librarian,@PathVariable("librarianId") int librarianId)
	{
		LibrarianDto updateLibrarian = this.librarianService.updateLibrarian(librarian, librarianId);
		return new ResponseEntity<LibrarianDto>(updateLibrarian,HttpStatus.OK);
	}

}
