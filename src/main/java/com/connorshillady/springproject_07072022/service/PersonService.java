package com.connorshillady.springproject_07072022.service;

import com.connorshillady.springproject_07072022.dao.PersonDAO;
import com.connorshillady.springproject_07072022.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class PersonService {
  private final PersonDAO personDAO;
  @Autowired
  public PersonService(@Qualifier("fakePersonDAO") PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  public int addPerson(Person person) {
    return personDAO.insertPerson(person);
  }
  public ArrayList<Person> selectAllPeople() {
    return personDAO.selectAllPeople();
  }
}