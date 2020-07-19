package com.yg.ClinicFromScratch.controllers;

import com.yg.ClinicFromScratch.models.Book;
import com.yg.ClinicFromScratch.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/index")
    public List<Book>getAllBook()
    {
        return bookService.getAll();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book>getById(@PathVariable Long id)
    {
        try {
            Book book=bookService.getById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/book/new")
    public void addNewBook(@RequestBody Book book)
    {
        bookService.save(book);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<?>update(@RequestBody Book book,@PathVariable Long id)
    {
        try {
            Book existBook=bookService.getById(id);
            bookService.save(book);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Long id)
    {
        bookService.deleteById(id);
    }
    @GetMapping("/book/docbook/{id}")
    public List<Book>getAllDoctorsById(@PathVariable Long id)
    {
        return bookService.getAllBookByDocId(id);
    }


    /*@PostMapping("/book/{docid}/{patid}")
    public void addNewBookByDocPat(@RequestBody Book book,@PathVariable Long docid,@PathVariable Long patid)
    {
        book=new Book(docid,patid,"4/5/20");
        bookService.save(book);
    }*/



}
