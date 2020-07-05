package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Patient;

import java.util.List;

public interface PatientService {

    List<Patient>getAllByBloodGroup(String bloodgroup);

    List<Patient>getAll();

    void save(Patient patient);

    Patient getById(Long id);

    void deleteById(Long id);
}
