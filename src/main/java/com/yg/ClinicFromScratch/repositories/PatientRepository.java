package com.yg.ClinicFromScratch.repositories;

import com.yg.ClinicFromScratch.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient>findByBloodGroup(String bloodgroup);

}
