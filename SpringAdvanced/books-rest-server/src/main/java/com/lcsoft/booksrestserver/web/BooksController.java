package com.lcsoft.booksrestserver.web;

import com.lcsoft.booksrestserver.model.dto.BookDTO;
import com.lcsoft.booksrestserver.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.
                ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") long bookId) {
        Optional<BookDTO> theBook = bookService.findBookById(bookId);
        return theBook
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteById(@PathVariable("id") long bookId) {
        bookService.deleteById(bookId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO newBook,
                                              UriComponentsBuilder uriComponentsBuilder) {
        long newBookId = bookService.createBook(newBook);
        return ResponseEntity.created(uriComponentsBuilder.
                path("api/books/{id}").build(newBookId))
                .build();
    }
}
