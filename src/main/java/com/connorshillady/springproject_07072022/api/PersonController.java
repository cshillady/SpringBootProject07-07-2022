package com.connorshillady.springproject_07072022.api;

import com.connorshillady.springproject_07072022.model.Person;
import com.connorshillady.springproject_07072022.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
  private final PersonService personService;
  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }
  @PostMapping
  public void addPerson(Person person) {
    personService.addPerson(new Person(person.getId(), person.getName()));
//    personService.addPerson(new Person(UUID.randomUUID(), "Bob"));
//    personService.addPerson(new Person(UUID.randomUUID(), "Sue"));
//    personService.addPerson(new Person(UUID.randomUUID(), "Molly"));
//    personService.addPerson(new Person(UUID.randomUUID(), "Don"));
  }
  @GetMapping
  public ArrayList<Person> getAllPeople() {
    return personService.selectAllPeople();
  }
}