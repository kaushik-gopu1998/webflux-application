package com.project.webflux.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.project.webflux.application.StudentConstants;
import com.project.webflux.application.handlers.StudentHandler;

@Configuration
public class StudentRouter {
	@Bean
	public RouterFunction<ServerResponse> routes(StudentHandler studentHandler){	
		return RouterFunctions.route()
			                  .GET(StudentConstants.FIND_ALL, studentHandler::getAll)
				              .GET(StudentConstants.STUDENT_BY_ID, studentHandler::get)
				              .POST(StudentConstants.STUDENT_INSERT, studentHandler::insertStudentRecord)
				              .PUT(StudentConstants.STUDENT_UPDATE_BY_ID, studentHandler::updateStudentRecord)
				              .build();
	}
}
