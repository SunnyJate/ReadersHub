package com.app.entities;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "books")
public class Author extends BaseEntity {

	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 30, unique = true) // =>unique
	private String email;
	@Column(nullable = false) // =>NOT NULL
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	@Column(length = 30,  unique = true)
	private long mobileNumber;
	
	@Column(length = 30)
	private int age = calculateAge(dob);
	
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true /* , fetch = FetchType.EAGER */ )
	private List<Book> books = new ArrayList<>();
	
	public static int calculateAge(LocalDate dob)   
	{  
		//creating an instance of the LocalDate class and invoking the now() method      
		//now() method obtains the current date from the system clock in the default time zone      
		LocalDate curDate = LocalDate.now();  
		//calculates the amount of time between two dates and returns the years  
		if ((dob != null) && (curDate != null))   
		{  
			return Period.between(dob, curDate).getYears();  
		}  
		else  
		{  
			return 0;  
		}  
	}

	public Author(String firstName, String lastName, String email, String password, LocalDate dob, long mobileNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
	}

	
	
}
