package com.library.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.LibrarianEntity;
import com.library.entity.StudentEntity;
import com.library.exception.ResourceNotFoundException;
import com.library.payload.LibrarianDto;
import com.library.payload.StudentDto;
import com.library.repository.LibrarianRepository;
import com.library.service.LibrarianService;
@Service
public class LibrarianServiceImlementation implements LibrarianService {
	@Autowired
	private LibrarianRepository librarianRepository;
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public LibrarianDto addlibrarian(LibrarianDto librarianDto) {
		LibrarianEntity librarianEntity=this.modelMapper.map(librarianDto,LibrarianEntity.class);
		LibrarianEntity savedLibrarian=this.librarianRepository.save(librarianEntity);
		
		return this.modelMapper.map(savedLibrarian, LibrarianDto.class);
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<LibrarianDto> getAllLibrarians() {
		// TODO Auto-generated method stub
		List<LibrarianEntity> librarianList=this.librarianRepository.findAll();
		List<LibrarianDto> librarianDtoList=librarianList.stream().
											map((librarian)->this.modelMapper.
													map(librarian,LibrarianDto.class)).collect(Collectors.toList());
		return librarianDtoList;
	}
	@Override
	public LibrarianDto getLibrarianById(int librarianId) {
		LibrarianEntity librarian= this.librarianRepository.findById(librarianId).orElseThrow(()->
		new ResourceNotFoundException("Librarian","Librarian Id",librarianId));
		return this.modelMapper.map(librarian,LibrarianDto.class);
	}
	@Override
	public void deleteLibrarianById(int librarianId) {
		// TODO Auto-generated method stub
		this.librarianRepository.findById(librarianId).orElseThrow(()->
		new ResourceNotFoundException("Librarian","Librarian Id",librarianId));
		this.librarianRepository.deleteById(librarianId);
		
		//this.modelMapper.map(librarianId,LibrarianDto.class);

		
	}
	@Override
	public LibrarianDto updateLibrarian(LibrarianDto librarianDto, int librarianId) {
		// TODO Auto-generated method stub
		LibrarianEntity librarianobj=this.librarianRepository.findById(librarianId).orElseThrow(()->
		new ResourceNotFoundException("librarian", "librarian id", librarianId));
		librarianDto.setLibrarianId(librarianId);
		LibrarianEntity updatelibrarian=this.modelMapper.map(librarianDto, LibrarianEntity.class);
		LibrarianEntity entity= this.librarianRepository.save(updatelibrarian);
		return this.modelMapper.map(entity, LibrarianDto.class);
		
	
	}
	
	

}
