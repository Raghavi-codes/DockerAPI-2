package com.example.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Person;
import com.example.Repo.PersonRepo;


@Service
public class PersonService {
	@Autowired
	private PersonRepo personRepo;
	
	public String addPerson(Person person) {
		personRepo.save(person);
		return "Saved";
	}
	public Person  getPerson(Integer id) {
   Optional<Person> person = personRepo.findById(id);
   if(person.isPresent()) {
	   return person.get();
	   }
   return null;
	}
	public List<Person> getPersons(){
		return personRepo.findAll();
	}
	public String deletePerson(Integer id) {
		if(personRepo.existsById(id)) {
			personRepo.deleteById(id);
		return "deleted";
		}else {
			return "no record found";
		}
		
	}
	public String updatePerson(Person person) {
		 personRepo.save(person);
		 return "person updated";
		
	}

}
