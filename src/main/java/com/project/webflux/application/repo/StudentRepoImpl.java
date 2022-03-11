package com.project.webflux.application.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Component;

import com.mongodb.client.result.UpdateResult;
import com.project.webflux.application.StudentConstants;
import com.project.webflux.application.entity.Student;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class StudentRepoImpl implements StudentRepository {
	
	private final ReactiveMongoTemplate template;
	@Override
	public Mono<Student> findById(Integer id) {
		return template.findById(id, Student.class);
	}
	@Override
	public Flux<Student> findAll() {
		return template.findAll(Student.class);
	}
	@Override
	public Mono<Student> save(Mono<Student> student) {
		
		return template.save(student);
	}
	@Override
	public Mono<UpdateResult> update(Mono<Student> student,Integer id) {
		
	    return null;	
	}
}
