package no.ntnu.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private List<Author> authors;

    public AuthorController() {
        initializeData();
    }

    private void initializeData() {
        authors = new ArrayList<>();
        authors.add(new Author(1, "Dan", "Brown", 1932));
        authors.add(new Author(2, "Jules", "Verne", 1763));
        authors.add(new Author(3, "Mary", "Shelley", 1642));
    }

    @GetMapping("")
    public List<Author> getAuthors() {
        return this.authors;
    }
}
