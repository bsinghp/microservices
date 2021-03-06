package com.synechron;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class MyReactiveController {

	@GetMapping(value = "/numbers", produces = MediaType.APPLICATION_NDJSON_VALUE)
	public Flux<Integer> getNumbers() {
		return Flux
				.range(1, 10)
				.delayElements(Duration.ofSeconds(1));
	}
}
