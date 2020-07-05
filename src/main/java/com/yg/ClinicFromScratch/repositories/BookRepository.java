package com.yg.ClinicFromScratch.repositories;

import com.yg.ClinicFromScratch.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {

    //@Modifying
    //@Query("Select b from book b where b.docid=:docid")
    List<Book>findAllByDocId(Long docId);

}
