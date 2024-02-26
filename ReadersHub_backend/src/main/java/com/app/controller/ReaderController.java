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

import com.app.dto.ReaderDTO;
import com.app.service.ReaderService;

@RestController
@RequestMapping("/reader")
@Validated
@CrossOrigin(origins = "http://localhost:3000")
public class ReaderController {

	@Autowired
	private ReaderService readerService;
	
	@PostMapping
	public ResponseEntity<?> addNewReader(@RequestBody @Valid ReaderDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(readerService.addNewReader(dto));
	}
	
	@GetMapping("/{readerId}")
	public ResponseEntity<?> getReaderDetails(@PathVariable Long readerId){
		return ResponseEntity.ok(readerService.getReaderDetails(readerId));
	}
	
	@PutMapping("/{readerId}")
	public ResponseEntity<?> updateReader(@PathVariable Long readerId,@RequestBody @Valid ReaderDTO dto){
		return ResponseEntity.ok(readerService.updateReader(readerId, dto));
	}
	
	@DeleteMapping("/{readerId}")
	public ResponseEntity<?> deleteReader(@PathVariable Long readerId){
		return ResponseEntity.ok(readerService.deleteReader(readerId));
	}
	
	@GetMapping
	public ResponseEntity<?> getAllReaders(){
		return ResponseEntity.ok(readerService.getAllReaders());
	}
	
}
