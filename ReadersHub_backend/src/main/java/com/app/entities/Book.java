package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="books")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = { "author" ,"logs","genres"}, callSuper = true)
public class Book extends BaseEntity {

	@Column(length = 50)
	private String title;
	@Enumerated(EnumType.STRING) 
	@Column(length = 30)
	private Language language;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id")
	private Author author;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<Genre> genres = new ArrayList<>();
	@Column
	private String imagePath;
	@Column
	private String pdfPath;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<ReaderBookLog> logs = new ArrayList<>();
	
	public Book(String title, Language language, Author author, String imagePath, String pdfPath) {
		super();
		this.title = title;
		this.language = language;
		this.author = author;
		this.imagePath = imagePath;
		this.pdfPath = pdfPath;
	}
	
}
