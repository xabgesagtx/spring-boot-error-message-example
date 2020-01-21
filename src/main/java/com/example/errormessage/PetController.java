package com.example.errormessage;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PetController {

	@PostMapping(value = "/html/buyPet/{id}", produces = MediaType.TEXT_HTML_VALUE)
	public Mono<String> buyPetHtml(@PathVariable long id) {
		return Mono.error(new PetNotFoundException(id));
	}

	@PostMapping(value = "/json/buyPet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Mono<String> buyPetJson(@PathVariable long id) {
		return Mono.error(new PetNotFoundException(id));
	}

}
