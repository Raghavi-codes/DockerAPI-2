package com.example.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Person;
import com.example.Service.PersonService;


@RestController
public class PersonController {
	@Autowired
	private PersonService personService;
	@PostMapping("/person")
	public ResponseEntity<String> addPerson(@RequestBody Person person){
		String Status = personService.addPerson(person);
		return new ResponseEntity<>(Status,HttpStatus.CREATED);
		
	}
	@GetMapping("/person/{id}")
	public ResponseEntity<Person> getPerson(@PathVariable Integer id){
		Person Status = personService.getPerson(id);
		return new ResponseEntity<>(Status,HttpStatus.OK);
		
	}
	@GetMapping("/persons")
	public ResponseEntity<List<Person>> getPersons(){
		List<Person> persons = personService.getPersons();
		return new ResponseEntity<>(persons,HttpStatus.OK);
		
	}
	@PutMapping("/person")
	public ResponseEntity<String>  updatePerson(@RequestBody Person person){
		String Status = personService.updatePerson(person);
		return new ResponseEntity<>(Status,HttpStatus.CREATED);
	}
	@DeleteMapping("/person/{id}")
	public ResponseEntity<String> deletePerson(@PathVariable Integer id){
    String Status = personService.deletePerson(id);
    return new ResponseEntity<>(Status,HttpStatus.OK);
	}

}

