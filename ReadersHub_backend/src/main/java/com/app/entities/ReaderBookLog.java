package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="reader_book_log")
@NoArgsConstructor
@Getter
@Setter
public class ReaderBookLog extends BaseEntity {

	@Enumerated(EnumType.STRING) 
	@Column(length = 30)
	private Rating rating;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reader_id")
	private Reader reader;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="book_id")
	private Book book;
	
	public ReaderBookLog(Rating rating, Reader reader, Book book) {
		super();
		this.rating = rating;
		this.reader = reader;
		this.book = book;
	}

	
	
	
}
