package com.yg.ClinicFromScratch.controllers;

import com.yg.ClinicFromScratch.models.Doctor;
import com.yg.ClinicFromScratch.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctor/index")
    public List<Doctor> getAllDoctors() {

        return doctorService.getAll();
    }

    @GetMapping("/doctor/viewDoctorById")
    public ResponseEntity<Doctor>getById(@PathVariable Long id)
    {
        try {
            Doctor doctor=doctorService.getById(id);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Doctor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctor/registerDoctor")
    public void addNewDoctor(@RequestBody Doctor doctor)
    {
        /*if(doctorService.getById(doctor.getDoctorID())!=null)
        {
            return new ResponseEntity<>("Doctor with id: "+doctor.getDoctorID()+" already exists",HttpStatus.CONFLICT);
        }
        */
            doctorService.save(doctor);
           // Doctor addedDoc=doctorService.getById(doctor.getDoctorID());

           // return new ResponseEntity<>("Doctor with id: "+addedDoc.getDoctorID()+" created successfully",HttpStatus.CREATED);

    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<?>update(@RequestBody Doctor doctor,@PathVariable Long id)
    {
        try {
            Doctor existDoctor=doctorService.getById(id);
            doctorService.save(doctor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/doctor/{id}")
    public void delete(@PathVariable Long id)
    {
        doctorService.deleteById(id);
    }


    @GetMapping("/doctor/spec/{speciality}")
    public List<Doctor> getAllDoctorsBySpec(@PathVariable String speciality ) {
        return doctorService.getDoctorBySpeciality(speciality);
    }

    @GetMapping("/doctor/name/{name}")
    public List<Doctor> getAllDoctorsByName(@PathVariable String name) {
        return doctorService.getDoctorByName(name);
    }

    @GetMapping("/doctor/symptom/{symptom}")
    public List<Doctor> getAllDoctorsBySymptoms(@PathVariable String symptom) {
        return doctorService.getDoctorBySymptoms(symptom);
    }

    }
