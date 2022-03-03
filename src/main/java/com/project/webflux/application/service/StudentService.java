package com.project.webflux.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.webflux.application.entity.Student;
import com.project.webflux.application.repo.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service

public class StudentService {
	
	@Autowired
	private  StudentRepository studentRepo;
   
	public Flux<Student> getAllStudents(){
		return studentRepo.findAll();
	}

	public Mono<Student> getStudentById(Integer studentId) {
		
		return studentRepo.findById(studentId);
	}

	public Mono<Void> insertStudentRecord(Student student) {
		return studentRepo.save(student).then();		
	}

	public Mono<Boolean> deleteStudentById(Integer studentId) {
		
		return studentRepo.findById(studentId)
				          .flatMap(student->{
				        	  student.setIsActive(false);
				        	  return insertStudentRecord(student).then(Mono.just(true));
				          })
				          .switchIfEmpty(Mono.just(false));
	}

}
