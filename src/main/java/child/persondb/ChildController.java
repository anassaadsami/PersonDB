package child.persondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ChildController {
    @Autowired
    private ChildService childService;

    @GetMapping("/getChildren")
    public List<Child> getAllChildren() {
        return childService.getAllChildren();
    }

    @GetMapping("/getChild/{name}")
    public Optional<Child> getChild(@PathVariable String name) {
        return childService.getChild(name);
    }

    @PostMapping("/addChild")
    public String addChild(@RequestBody Child child) {
        childService.addChild(child);
        return "child object is added";
    }

    @PutMapping("/updateChild/{name}")
    public void updateBook(@PathVariable String name, @RequestBody Child child) {
        childService.updateChild(name, child);
    }


    @DeleteMapping("/deleteChild/{name}")
    public String deleteChild(@PathVariable String name) {
        childService.deleteChild(name);
        return String.format("%s is deleted", name);  // to get message with deleted object's name
    }
}


