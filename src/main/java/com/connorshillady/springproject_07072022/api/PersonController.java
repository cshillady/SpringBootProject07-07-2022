package com.connorshillady.springproject_07072022.api;

import com.connorshillady.springproject_07072022.model.Person;
import com.connorshillady.springproject_07072022.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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
  
  @GetMapping(value = "/post/{id}/{name}")
  public void addPerson(@PathVariable UUID id, @PathVariable String name) {
    personService.addPerson(new Person(id, name));
  }
  
  @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    /*
    {
        "id": "",
        "name": "james"
    }
     */
  public void addPerson(@RequestBody Person person){
    personService.addPerson(person);
  }
  @GetMapping
  public ArrayList<Person> getAllPeople() {
    return personService.selectAllPeople();
  }
  @GetMapping(value = "/{id}")
  public Person getPerson(@PathVariable("id") UUID id) {
    return personService.getPersonById(id).orElse(null);
  }
  
  @DeleteMapping(value = "/{id}")
  public int deletePerson(@PathVariable("id") UUID id){
    return personService.deletePerson(id);
  }
  @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public int updatePerson(@PathVariable("id") UUID id, @RequestBody Person person){
    return personService.updatePerson(id, person);
  }
}