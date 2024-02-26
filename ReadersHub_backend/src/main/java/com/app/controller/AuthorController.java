package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthorDTO;
import com.app.service.AuthorService;

@RestController
@RequestMapping("/author")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PostMapping
	public ResponseEntity<?> addNewAuthor(@RequestBody @Valid AuthorDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(authorService.addNewAuthor(dto));
	}
	
	@GetMapping("/{authorId}")
	public ResponseEntity<?> getAuthorDetails(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.getAuthorDetails(authorId));
	}
	
	@PutMapping("/{authorId}")
	public ResponseEntity<?> updateAuthor(@PathVariable Long authorId,@RequestBody @Valid AuthorDTO dto){
		return ResponseEntity.ok(authorService.updateAuthor(authorId, dto));
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<?> deleteAuthor(@PathVariable Long authorId){
		return ResponseEntity.ok(authorService.deleteAuthor(authorId));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllAuthors(){
		return ResponseEntity.ok(authorService.getAllAuthors());
	}
}
