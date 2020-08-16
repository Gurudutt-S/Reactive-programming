package com.reactiveSpring.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FluxAndMonoController {

	@GetMapping("/flux")
	public Flux<Integer> returnFlux() {
		return Flux.just(1, 2, 3, 4)
				.log();
	}
	
	@GetMapping(value="/flux-delay", produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> returnFluxDelay() {
		return Flux.just("Spring","Boot","using","Reactor")
				.delayElements(Duration.ofSeconds(1))
				.log();
	}
	
	@GetMapping("/mono")
	public Mono<String> returnMono(){
		return Mono.just("Hello World")
				.log();
	}

}
