package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Doctor;

import java.util.*;

public interface DoctorService {


    //ALL CRUD OPERATIONS
    List<Doctor>getAll();

    void save(Doctor doctor);

    Doctor getById(Long id);

    void deleteById(Long id);
}
