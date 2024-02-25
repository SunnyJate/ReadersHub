package com.app.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AuthorDTO {

	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@Email
	@NotBlank
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY) 
	private String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	private long mobileNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;
	
	
	
}
