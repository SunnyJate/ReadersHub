package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Reader;

public interface ReaderDao extends JpaRepository<Reader, Long> {

	Optional<Reader> findByEmailAndPassword(String em,String pass);

}
