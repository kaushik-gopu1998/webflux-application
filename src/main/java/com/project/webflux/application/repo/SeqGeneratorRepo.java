package com.project.webflux.application.repo;


import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import com.project.webflux.application.entity.SequenceGenerator;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SeqGeneratorRepo {
	private final ReactiveMongoTemplate template;
	public Mono<SequenceGenerator> getMaxId() {
		return template.findAll(SequenceGenerator.class).single();
		
	}
}
