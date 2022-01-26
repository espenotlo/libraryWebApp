package no.ntnu.library;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private List<Book> books;

    public BookController() {
    initializeData();
    }

    private void initializeData() {
        books = new ArrayList<>();
        books.add(new Book(1, "Angels and Demons", 2001, 325));
        books.add(new Book(2, "The Da Vinci Code", 1999, 452));
        books.add(new Book(3, "The Digital Fortress", 2004, 298));
        books.add(new Book(4, "Moby Dick", 1792, 132));
        books.add(new Book(5, "Gulliver's Travels", 1892, 423));
    }

    @GetMapping("")
    public List<Book> getBooks() {
        return this.books;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Book book = getBookById(id);
        if (null != book) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private Book getBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
}
