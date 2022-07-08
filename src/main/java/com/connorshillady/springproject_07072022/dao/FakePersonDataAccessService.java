package com.connorshillady.springproject_07072022.dao;

import com.connorshillady.springproject_07072022.model.Person;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Optional;
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
  @Override
  public int deletePersonById(UUID id) {
    Optional<Person> personMaybe = selectPersonById(id);
    if (personMaybe.isEmpty()) {
      return 0;
    }
    PersonDB.remove(personMaybe.get());
    return 1;
  }
  @Override
  public int updatePersonById(UUID id, Person updatePerson) {
    return selectPersonById(id)
        .map(origPerson -> {
          int updateIndex = PersonDB.indexOf(origPerson);
          if (updateIndex >= 0) {
            PersonDB.set(updateIndex, updatePerson);
            return 1;
          }
          return 0;
        }).orElse(0);
  }
  public Optional<Person> selectPersonById(UUID id) {
    return PersonDB.stream().filter(person -> person.getId().equals(id)).findFirst();
  }
}