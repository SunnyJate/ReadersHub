package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Author;

public interface AuthorDao extends JpaRepository<Author, Long> {

	Optional<Author> findByEmailAndPassword(String em,String pass);

}
