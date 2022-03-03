package com.project.webflux.application.entity;


import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="student")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	@Id
	Integer pin;
	String firstName;
	String lastName;
	String gender;
	Instant dateOfBirth;//issue with date
	String course;
	Instant yearOfJoining;
	Boolean isActive;
}
