package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dao.ReaderDao;
import com.app.dto.ApiResponse;
import com.app.dto.ReaderDTO;
import com.app.entities.Reader;

@Service
@Transactional
public class ReaderServiceImpl implements ReaderService {

	@Autowired
	private ReaderDao readerDao;

	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<ReaderDTO> getAllReaders() {
		return readerDao.findAll()
				.stream()
				.map(reader->mapper.map(reader, ReaderDTO.class))
				.collect(Collectors.toList());
	}
	
	@Override
	public ReaderDTO getReaderDetails(Long readerID) {
		Reader reader=readerDao.findById(readerID)
				.orElseThrow(()->new ResourceNotFoundException("Invalid JobseekerId"));
		return mapper.map(reader, ReaderDTO.class);
	}
	

	@Override
	public ReaderDTO addNewReader(ReaderDTO reader) {
		Reader readerEntity = mapper.map(reader, Reader.class);
		Reader persistentReader = readerDao.save(readerEntity);
		return mapper.map(persistentReader, ReaderDTO.class);
	}

	@Override
	public ReaderDTO updateReader(Long readerId, ReaderDTO reader) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApiResponse deleteReader(Long readerId) {
		Reader reader=readerDao.findById(readerId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid Id"));
		readerDao.deleteById(readerId);
		return new ApiResponse("Jobseeker details with Id"+reader.getId()+"deleted..");
	}


	

}
