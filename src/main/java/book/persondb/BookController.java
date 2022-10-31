package book.persondb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/getPerson/{name}/allBooks")
    public List<Book> getAllBooks(@PathVariable String name){
      return   bookService.getAllBooks(name);
    }

    // this one be optional also , but we add get() in the end
    @GetMapping("/getPerson/{name}/getBook/{bookName}")
    public Optional<Book> getBook(@PathVariable  String bookName ){
        return bookService.getBook(bookName);
    }

    @PostMapping("/addBook")
    public String addBook2(@ RequestBody Book child, @PathVariable String name){
        child = new Book(child.getBookName(), child.getPage(), name);
        //  book.setPerson(new Person(name,0));   // ??
        // book.setBookName(book.getBookName());
        // book.setPage(book.getPage());
        bookService.addBook(child);
        return "book object is added";
    }

    @PostMapping("/getPerson/{name}/addBook")
    public String addBook(@ RequestBody Book book, @PathVariable String name){
        book = new Book(book.getBookName(), book.getPage(), name);
      //  book.setPerson(new Person(name,0));   // ??
       // book.setBookName(book.getBookName());
       // book.setPage(book.getPage());
        bookService.addBook(book);
        return "book object is added";
    }

    @PutMapping("/updateBook/{bookName}")
    public void updateBook (@RequestBody Book child, @PathVariable String bookName , @PathVariable String name){
        child.getPerson().setName(name);
        bookService.updateBook(bookName , child);
    }

    // another way to update, so we put the updated attributes for object here inside method
    @PutMapping("/updateBook2/{bookName}")
    public String  updateBook2 (@RequestBody Book child, @PathVariable String bookName ){
        Book updatedChild = bookService.getBook(bookName).get();   // we add get() in the end to avoid optional return type
        updatedChild.setBookName(child.getBookName());
        updatedChild.setPage(child.getPage());
        bookService.updateBook(bookName, child);
        return "book is updated";
    }

    @DeleteMapping("/deleteBook/{bookName}")
    public String deleteBook(@PathVariable String bookName ){
        bookService.deleteBook(bookName);
        return String.format("%s is deleted",bookName);  // to get message with deleted object's name
    }
}
