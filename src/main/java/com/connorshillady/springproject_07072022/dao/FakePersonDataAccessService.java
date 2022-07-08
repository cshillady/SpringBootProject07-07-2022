package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.UUID;

@Repository("fakePersonDAO")
public class FakePersonDataAccessService implements PersonDAO {
  private static ArrayList<Person> PersonDB = new ArrayList<>();
  @Override
  public int insertPerson(UUID id, Person person) {
    PersonDB.add(new Person(id, person.getName()));
    return 1;
  }
  @Override
  public ArrayList<Person> selectAllPeople() {
    return PersonDB;
  }
}