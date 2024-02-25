package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.AuthorDTO;

public interface AuthorService {

	List<AuthorDTO> getAllAuthors();
	AuthorDTO getAuthorDetails(Long authId);
	
	AuthorDTO addNewAuthor(AuthorDTO auth);
	AuthorDTO updateAuthor(Long authId, AuthorDTO auth);
	
	ApiResponse deleteAuthor(Long authorId);
}
