package com.app.service;

import java.util.List;

import com.app.dto.ApiResponse;
import com.app.dto.ReaderDTO;

public interface ReaderService {
	
	List<ReaderDTO> getAllReaders();
	ReaderDTO getReaderDetails(Long authId);
	
	ReaderDTO addNewReader(ReaderDTO reader);
	ReaderDTO updateReader(Long readerId, ReaderDTO reader);
	
	ApiResponse deleteReader(Long readerId);
}
