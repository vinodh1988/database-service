package com.microservice.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.app.entity.Person;
import com.microservice.app.services.DataService;

@RestController
@RequestMapping("/api")
public class RestAPI {
   
	@Autowired
	DataService data;
	
	@GetMapping(value="/people")
	public List<Person> getPeople(){
		return data.getPeople(); //return list of person - automatically ll be converted json
		   
	}
	
	@PostMapping("/people")
	@Transactional
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		try {	
			data.addPerson(person);
			data.addKey(person.getSno());
		
			return new ResponseEntity<Person>(person,HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Person>(HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
}
