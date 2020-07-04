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
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @GetMapping("/doctor/index")
    public List<Doctor> getAllDoctors() {

        return doctorService.getAll();
    }

    @GetMapping("/doctor/{id}")
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

    @PostMapping("/doctor/new")
    public void addNewDoctor(@RequestBody Doctor doctor)
    {
        doctorService.save(doctor);
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

}
