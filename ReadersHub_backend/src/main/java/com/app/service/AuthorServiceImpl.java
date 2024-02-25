package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.AuthorDao;
import com.app.dto.ApiResponse;
import com.app.dto.AuthorDTO;
import com.app.entities.Author;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<AuthorDTO> getAllAuthors() {
		return authorDao.findAll()
				.stream()
				.map(author->mapper.map(author, AuthorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public AuthorDTO getAuthorDetails(Long authId) {
		// TODO Auto-generated method stub
		Author author=authorDao.findById(authId)
				.orElseThrow(()->new ResourceNotFoundException("Invalid JobseekerId"));
		return mapper.map(author, AuthorDTO.class);
	}

	@Override
	public AuthorDTO addNewAuthor(AuthorDTO auth) {
		Author authorEntity = mapper.map(auth, Author.class);
		Author persistentAuth = authorDao.save(authorEntity);
		return mapper.map(persistentAuth, AuthorDTO.class);
	}

	@Override
	public AuthorDTO updateAuthor(Long authId, AuthorDTO auth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteAuthor(Long authorId) {
		Author author=authorDao.findById(authorId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		authorDao.deleteById(authorId);
		return new ApiResponse("Jobseeker details with Id"+author.getId()+"deleted..");
	}

}
