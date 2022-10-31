package com.example.persondb.child;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Child {
    @Id
    private String childName;
    private int age;


}
