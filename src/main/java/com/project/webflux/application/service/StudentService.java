package com.project.webflux.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mongodb.client.result.UpdateResult;
import com.project.webflux.application.entity.SequenceGenerator;
import com.project.webflux.application.entity.Student;
import com.project.webflux.application.repo.SeqGeneratorRepo;
import com.project.webflux.application.repo.StudentRepository;

import reactor.core.publisher.Mono;

@Service

public class StudentService {
	@Autowired
	private  StudentRepository studentRepo;
	
   
	public Mono<Student> getStudentById(Integer studentId) {
		return studentRepo.findById(studentId);				
	}

	public Mono<List<Student>> getAllStudents() {
		return studentRepo.findAll().collectList();
	}

	public Mono<Student> insert(Mono<Student> student) {
		return student
				.flatMap(newStu->{
					return studentRepo.save(Mono.just(newStu));
				});
	}
	
	public Mono<Student> update(Mono<Student> student , Integer id){
		return null;
				
				
				
				
				          
	}

	private Object transform(Mono<Student> student) {
		// TODO Auto-generated method stu
		
		return null;
	}
    
		
}
