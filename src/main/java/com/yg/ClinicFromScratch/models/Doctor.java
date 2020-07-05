package com.yg.ClinicFromScratch.models;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "doctor")
@NoArgsConstructor
public class Doctor {

    @Id
    private Long doctorID;

    private String name;
    private String phone;
    private String address;

    @Lob
    private String dutydays;
    private String dutytime;

    private String speciality;
    private String symptoms;

    private Integer consultationfee;

    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "doctor")
    //private Set<Book> bookings=new HashSet<>();


    public Doctor(String name, String phone, String address, String dutydays, String dutytime, String speciality, String symptoms, Integer consultationfee) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dutydays = dutydays;
        this.dutytime = dutytime;
        this.speciality = speciality;
        this.symptoms = symptoms;
        this.consultationfee = consultationfee;
    }

    public Doctor(Long doctorID, String name, String phone, String address, String dutydays, String dutytime, String speciality, String symptoms, Integer consultationfee) {
        this(name,phone,address,dutydays,dutytime,speciality,symptoms,consultationfee);
        this.doctorID = doctorID;

    }
}
