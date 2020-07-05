package com.yg.ClinicFromScratch.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity(name = "patient")
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patientID")
    private Long patientID;

    private String name;
    private String phone;
    private String address;

    @Column(name="date_of_birth")
    private String dob;

    @Column(name = "blood_group")
    private String bloodGroup;

    public Patient(Long patientID, String name, String phone, String address, String dob, String bloodGroup) {
        this(name,phone,address,dob,bloodGroup);
        this.patientID = patientID;

    }

    public Patient(String name, String phone, String address, String dob, String bloodGroup) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
    }
}
