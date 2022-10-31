package child.persondb;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChildRepository extends CrudRepository<Child,String> {
    /*
    by default, we have just 2 methods in Repository interface : findAll , findByIn ( and Inn here is primary key
    for book object) but we want to get the books by person name and that's why we create here this method
    to can invoke it in service class .
     */
   //  List<Child> findAllByPersonId(String name);
}
