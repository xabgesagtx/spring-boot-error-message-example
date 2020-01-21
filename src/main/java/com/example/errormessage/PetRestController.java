package com.example.errormessage;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("rest")
public class PetRestController {

	@PostMapping("buyPet/{id}")
	public Mono<String> buyPet(@PathVariable Long id) {
		return Mono.error(new PetNotFoundException(id));
	}
}
