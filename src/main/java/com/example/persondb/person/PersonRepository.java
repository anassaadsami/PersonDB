package com.example.persondb.person;

import com.example.persondb.person.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person,String> {
}
