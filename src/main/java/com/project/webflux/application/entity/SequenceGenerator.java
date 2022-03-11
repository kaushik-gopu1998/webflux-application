package com.project.webflux.application.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Document(collection="SequennceGenerator")
@Data
@AllArgsConstructor
public class SequenceGenerator {
	@Id
	Integer id;
	Integer pin;

}
