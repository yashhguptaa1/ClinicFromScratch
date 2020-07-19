package com.yg.ClinicFromScratch.controllers;

import com.yg.ClinicFromScratch.models.Patient;
import com.yg.ClinicFromScratch.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/patient/index")
    public List<Patient>getAllPatients()
    {
        return patientService.getAll();
    }

    @GetMapping("patient/{id}")
    public ResponseEntity<Patient>getById(@PathVariable Long id)
    {
        try{
            Patient patient=patientService.getById(id);
            return new ResponseEntity<Patient>(patient, HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<Patient>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/patient/new")
    public void addNewPatient(@RequestBody Patient patient)
    {
        patientService.save(patient);
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<?>update(@RequestBody Patient patient,@PathVariable Long id)
    {
        try {
            Patient existPatient=patientService.getById(id);
            patientService.save(patient);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id)
    {
        patientService.deleteById(id);
    }
    @GetMapping("/patient/bg/{bloodgroup}")
    public List<Patient>getAllByBloodGroup(@PathVariable String bloodgroup)
    {
        return patientService.getAllByBloodGroup(bloodgroup);
    }
}
