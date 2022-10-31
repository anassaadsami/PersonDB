package book.persondb;

import com.example.persondb.Person;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    private String bookName;

    private int page;
// every person have many books
    @OneToOne
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + bookName + '\'' +
                ", page=" + page +
                ", person=" + person.getName() +
                '}';
    }
    public Book() {
    }

    // we need just person name for every book which need to indicate
    public Book(String name, int page, String personName) {
        this.bookName = name;
        this.page = page;
       // this.person.setName(personName);
        this.person = new Person(personName,0);
        System.out.println("book object is created");
    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int age) {
        this.page = age;
    }
}
