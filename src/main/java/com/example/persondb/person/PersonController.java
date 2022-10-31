package com.example.persondb.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @GetMapping("/allPersons")
    public List<Person> getAllPersons(){
      return   personService.getAllPerson();
    }

    // this one be optional also
    @GetMapping("/getPerson/{name}")
    public Optional<Person> getPerson(@PathVariable  String name ){
        return personService.getPerson(name);
    }

    @PostMapping("/addPerson")
    public String addPerson(@ RequestBody Person person){
        personService.addPerson(person);
        return "person object is added";
    }

    @PutMapping("/updatePerson/{name}")
    public String updatePerson(@RequestBody Person person, @PathVariable String name ){
        personService.updatePerson(name, person);
        return "object is updated";
    }

    @DeleteMapping("/deletePerson/{name}")
    public String deletePerson(@PathVariable String name ){
        personService.deletePerson(name);
        return String.format("%s is deleted",name);  // to get message with deleted object's name
    }
}
