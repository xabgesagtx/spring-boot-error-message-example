package com.example.errormessage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PetNotFoundException extends RuntimeException {
	PetNotFoundException(long id) {
		super("Could not find pet with id " + id);
	}
}
