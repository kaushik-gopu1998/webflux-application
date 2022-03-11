package com.project.webflux.application.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.webflux.application.entity.Student;
import com.project.webflux.application.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentManagementController {
	@Autowired
	private StudentService studentService;
	private static final Logger logger = LoggerFactory.getLogger(StudentManagementController.class);
	@GetMapping("/retrieveAll")
	public Flux<Student> getAllStudents(){
		return studentService.getAllStudents();
	}	
	@GetMapping("/getStu/{studentId}")
	public Mono<Student> getStudentById(@PathVariable("studentId") Integer studentId){
		Mono<Student> student = studentService.getStudentById(studentId);
		logger.info("retrieving the details of student id->{}",studentId);
		return student;
	}
	
	@PostMapping("/createRecord")
	public Mono<ResponseEntity<String>> createStudentRecord(@RequestBody Student student){
		logger.info("creating record for new Student");
		return studentService.insertStudentRecord(student)
				.then(Mono.just(new ResponseEntity<String>("success", HttpStatus.CREATED)));
				
	}
	
	@PutMapping("/updateRecord/{studentId}")
	public Mono<ResponseEntity<String>> updateStudentRecord(@RequestBody Student student, @PathVariable Integer studentId ){
		logger.info("updating record of student with Id->{}", studentId);
		return studentService.getStudentById(studentId)
				             .filter(oldStuData-> oldStuData.getIsActive()==true)
				             .flatMap(oldstuData->{
				            	 oldstuData.setFirstName(student.getFirstName());
				            	 oldstuData.setLastName(student.getLastName());
				            	 oldstuData.setDateOfBirth(student.getDateOfBirth());
				            	 oldstuData.setGender(student.getLastName());
				            	 oldstuData.setYearOfJoining(student.getYearOfJoining());
				            	 return studentService.insertStudentRecord(student)
				         				.then(Mono.just(new ResponseEntity<String>("update successful", HttpStatus.OK)));
				             }).switchIfEmpty(Mono.just(new ResponseEntity<String>("Invalid Data", HttpStatus.BAD_REQUEST)));
				             
		
		
	}
	
	@DeleteMapping("/deleteRecord/{studentId}")
	public Mono<ResponseEntity<String>> deleteStudentRecord(@PathVariable Integer studentId){
		logger.info("deleting record of student with Id->{}",studentId);
		return studentService.deleteStudentById(studentId)
				             .filter(result->result==true)
				             .then(Mono.just(new ResponseEntity<String>("delete operation successful", HttpStatus.OK)));
				             
				             
	}
	
	
	
}
