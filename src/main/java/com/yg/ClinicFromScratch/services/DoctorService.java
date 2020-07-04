package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Doctor;

import java.util.*;

public interface DoctorService {

    List<Doctor> getDoctorBySpeciality(String speciality);

    List<Doctor> getDoctorByName(String name);

    List<Doctor> getDoctorBySymptoms(String symptoms);


    //ALL CRUD OPERATIONS
    List<Doctor>getAll();

    void save(Doctor doctor);

    Doctor getById(Long id);

    void deleteById(Long id);
}
