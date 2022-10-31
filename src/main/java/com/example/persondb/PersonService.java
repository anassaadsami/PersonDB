package com.example.persondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository ;
        /*
         method to get all persons objects in person table in db.
        findAll() method is one of crudRepository method to find all elements in array
        and forEach is to add every element which found in db table and add in personList
         */
    public List<Person> getAllPerson(){
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);  // add is a method in arrayList so we can choose another if we need
       return personList;
       // return (List<Person>) personRepository.findAll();     // maybe the same
    }
/*
     to get a specific instance in table in db
     when we use findById method we must change the return type to Optional here and in Controller class also
 */
    public Optional<Person> getPerson(String name){
       return personRepository.findById(name);    // the Id here is name cause it's the name is the primary key in table db

    }
    // to add a new instance of person to person table in db
    public void addPerson(Person person){
        personRepository.save(person);

    }

    // to update a person instance by it's Id, we use save() also , if the person instance is already exit so we update
    // if not exit so we create it and save it .
    public void updatePerson(String name , Person person){
        personRepository.save(person);
    }

    // to delete en instance by it's Id
    public void deletePerson(String name){
        personRepository.deleteById(name);
    }


}
