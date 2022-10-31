package com.example.persondb.child;
import com.example.persondb.child.Child;
import com.example.persondb.child.ChildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChildService {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> getAllChildren(){
        List<Child> childList = new ArrayList<>();
        childRepository.findAll().forEach(childList::add);
       return childList;
       // return (List<Person>) personRepository.findAll();     // maybe the same
    }

    public Optional<Child>getChild(String childName){
       return childRepository.findById(childName);

    }

    public void addChild(Child child){
        childRepository.save(child);

    }

    public void updateChild(String childName , Child child){
        childRepository.save(child);
    }

    public void deleteChild(String childName){
        childRepository.deleteById(childName);
    }


}
