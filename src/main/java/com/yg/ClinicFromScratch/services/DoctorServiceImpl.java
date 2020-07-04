package com.yg.ClinicFromScratch.services;

import com.yg.ClinicFromScratch.models.Doctor;
import com.yg.ClinicFromScratch.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public List<Doctor>getAll()
    {
        return doctorRepository.findAll();
    }

    @Override
    public void save(Doctor doctor)
    {
        doctorRepository.save(doctor);
    }

    @Override
    public Doctor getById(Long id)
    {
        return doctorRepository.findById(id).get();
    }


    @Override
    public void deleteById(Long id) {

       doctorRepository.deleteById(id);
    }
}
