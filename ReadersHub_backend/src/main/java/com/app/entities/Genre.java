package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="genre")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Genre extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 30, nullable = false)
	private GenreTitle genreTitle;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "book_id",nullable = false)
	private Book book;
	
	public Genre(GenreTitle genreTitle, Book book) {
		super();
		this.genreTitle = genreTitle;
		this.book = book;
	}
	
	
}
