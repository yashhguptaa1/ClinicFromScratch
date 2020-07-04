package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Doctor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceImplTest {

    @Autowired
    DoctorService doctorService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAll() throws Exception{
        List<Doctor> doctors=doctorService.getAll();
        assertEquals(10,doctors.size());
    }

    @Test
    void save() {
    }

    @Test
    void getById() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getDoctorBySpeciality() {
    }

    @Test
    void getDoctorByName() {
    }

    @Test
    void getDoctorBySymptoms() {
    }

}