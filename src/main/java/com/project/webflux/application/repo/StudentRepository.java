package com.project.webflux.application.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.project.webflux.application.entity.Student;

@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, Integer> {

}
