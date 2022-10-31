package child.persondb;

import com.example.persondb.Person;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;




@Entity
public class Child {
    @Id
    private String childName;
    private int age;


}
