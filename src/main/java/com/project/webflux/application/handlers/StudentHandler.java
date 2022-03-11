package com.project.webflux.application.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.mongodb.client.result.UpdateResult;
import com.project.webflux.application.StudentConstants;
import com.project.webflux.application.entity.Student;
import com.project.webflux.application.service.StudentService;

import reactor.core.publisher.Mono;

@Component
public class StudentHandler {
	
	@Autowired
	StudentService studentService;
	
	public Mono<ServerResponse> get(ServerRequest req) {
		
		return studentService.getStudentById(Integer.valueOf(req.pathVariable(StudentConstants.STUDENT_ID_PATH_VARIABLE)))
				             .flatMap(student -> ServerResponse.ok().body(Mono.just(student),Student.class))
				             .switchIfEmpty(ServerResponse.notFound().build());
				                       
	}
	
	public Mono<ServerResponse> getAll(ServerRequest req){
		return studentService.getAllStudents()
				             .flatMap(students-> ServerResponse.ok().body(Mono.just(students),Student.class));
	}
	
	public Mono<ServerResponse> insertStudentRecord(ServerRequest req){
		Mono<Student> studentMono = req.bodyToMono(Student.class);
		return studentMono
				.flatMap(student ->
					ServerResponse.status(HttpStatus.CREATED)
					.contentType(MediaType.APPLICATION_JSON)
					.body(studentService.insert(Mono.just(student)),Student.class)
				);
		
	}
	
	public Mono<ServerResponse> updateStudentRecord(ServerRequest req){
		Mono<Student> studentMono = req.bodyToMono(Student.class);
		return studentService.update(studentMono,Integer.valueOf(req.pathVariable(StudentConstants.STUDENT_ID_PATH_VARIABLE)))
				             .flatMap(result->ServerResponse.ok().body(Mono.just(result),UpdateResult.class));		             
	}
}
