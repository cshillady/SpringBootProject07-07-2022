package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Person;
import java.util.ArrayList;
import java.util.UUID;

public interface PersonDAO {
  int insertPerson(UUID id, Person person);
  default int insertPerson(Person person) {
    UUID id = UUID.randomUUID();
    return insertPerson(id, person);
  }
  ArrayList<Person> selectAllPeople();
}