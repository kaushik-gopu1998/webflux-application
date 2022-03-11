package com.project.webflux.application.repo;

import com.mongodb.client.result.UpdateResult;
import com.project.webflux.application.entity.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository  {
	
	public Mono<Student> findById(Integer id);
	public Flux<Student> findAll();
	public Mono<Student> save(Mono<Student> student);
    public Mono<UpdateResult>  update(Mono<Student> student,Integer id);
}
