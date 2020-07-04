package com.yg.ClinicFromScratch.repositories;

import com.yg.ClinicFromScratch.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {


}
