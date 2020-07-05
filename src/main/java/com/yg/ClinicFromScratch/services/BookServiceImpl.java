package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Book;
import com.yg.ClinicFromScratch.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {

        bookRepository.save(book);
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public List<Book> getAllBookByDocId(Long docid) {
        return bookRepository.findAllByDocId(docid);
    }
}
