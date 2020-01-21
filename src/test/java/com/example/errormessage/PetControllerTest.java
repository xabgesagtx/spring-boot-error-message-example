package com.example.errormessage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
class PetControllerTest {

	@Autowired
	private WebTestClient client;

	@Test
	void buyPetHtml() throws Exception {
		client.post()
				.uri("/html/buyPet/1")
				.accept(MediaType.TEXT_HTML)
				.exchange()
			.expectStatus()
				.isBadRequest()
			.expectBody()
				.xpath("//h1").isEqualTo("400")
				.xpath("//h2").isEqualTo("Could not find pet with id 1");
	}

	@Test
	void buyPetJson() throws Exception {
		client.post()
				.uri("/json/buyPet/1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
			.expectStatus()
				.isBadRequest()
			.expectBody()
				.jsonPath("$.status").isEqualTo("400")
				.jsonPath("$.message").isEqualTo("Could not find pet with id 1");
	}
}