package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Patient;
import com.yg.ClinicFromScratch.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllByBloodGroup(String bloodgroup) {
        return patientRepository.findByBloodGroup(bloodgroup);
    }

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public void save(Patient patient) {

        patientRepository.save(patient);
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {

        patientRepository.deleteById(id);
    }
}
