package book.persondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
        /*
         method to get all persons objects in person table in db.
        findAll() method is one of crudRepository method to find all elements in array
        and forEach is to add every element which found in db table and add in personList
         */
    public List<Book> getAllBooks(String personName){
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAllByPersonId(personName).forEach(bookList::add);  // add is a method in arrayList so we can choose another if we need
       return bookList;
       // return (List<Person>) personRepository.findAll();     // maybe the same
    }
/*
     to get a specific instance in table in db
     when we use findById method we must change the return type to Optional here and in Controller class also .
     but here we add get() in the end
 */
    public Optional<Book>getBook(String bookName){
       return bookRepository.findById(bookName);    // the Id here is name cause it's the name is the primary key in table db

    }
    // to add a new instance of book to book table in db
    public void addBook(Book child){
        bookRepository.save(child);

    }

    // to update a person instance by it's Id, we use save() also , if the person instance is already exit so we update
    // if not exit so we create it and save it .
    public void updateBook(String bookName , Book book){
        bookRepository.save(book);
    }

    // to delete en instance by it's Id
    public void deleteBook(String bookName){
        bookRepository.deleteById(bookName);
    }


}
