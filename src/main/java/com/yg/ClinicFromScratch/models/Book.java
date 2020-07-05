package com.yg.ClinicFromScratch.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "book")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="bookID")
    private Long bookID;


    @Column(name="doc_id")
    private Long docId;

    @Column(name="patient_id")
    private Long patientId;

    @Column(name = "book_date")
    private String bookDate;

    @Column(name = "book_time")
    private String bookTime;

   /*@ManyToOne
    @JoinColumn(name = "docid",referencedColumnName = "doctorID")
    private Doctor doctor;
    */


    public Book(Long bookID, Long docId, Long patientId, String bookDate, String bookTime) {
        this(docId,patientId,bookDate,bookTime);
        this.bookID = bookID;

    }

    public Book(Long docId, Long patientId, String bookDate, String bookTime) {
        this.docId = docId;
        this.patientId = patientId;
        this.bookDate = bookDate;
        this.bookTime = bookTime;
    }
}
