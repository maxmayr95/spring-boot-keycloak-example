package com.maxmayr.personapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxmayr.personapp.model.Person;

@RestController
@RequestMapping("/persons")
@PreAuthorize("isAuthenticated()")
public class PersonController {

	@GetMapping(value = "")
	@PreAuthorize("hasRole('PERSON')")
	public ResponseEntity<Person> getPerson() {
		Person max = new Person();
		max.setName("Morty Smith");
		return new ResponseEntity<Person>(max, HttpStatus.OK);
	}
	
	@GetMapping(value = "/no-role")
	public ResponseEntity<Person> getPersonWithoutRole() {
		Person rickSanchez = new Person();
		rickSanchez.setName("Rick Sanchez");
		return new ResponseEntity<Person>(rickSanchez, HttpStatus.OK);
	}
	
}
