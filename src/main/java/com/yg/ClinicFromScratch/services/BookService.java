package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Book;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookService {

    List<Book>getAllBookByDocId(Long docid);

    //ALL CRUD OPERATIONS
    List<Book> getAll();

    void save(Book book);

    Book getById(Long id);

    void deleteById(Long id);
}
