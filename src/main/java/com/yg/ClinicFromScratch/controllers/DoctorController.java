package com.yg.ClinicFromScratch.controllers;

import com.yg.ClinicFromScratch.models.Doctor;
import com.yg.ClinicFromScratch.services.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping("/patient/index")
    public String getPatientIndexPage(Model model)
    {
        return "patient/index";
    }

    @GetMapping("/doctor/index")
    public String getAllDoctors(Model model) {

        List<Doctor>doctorList=doctorService.getAll();
        model.addAttribute("doctorList",doctorList);
        return "doctor/index";
    }

    @GetMapping("/doctor/new")
    public String showNewForm(Model model) {
        Doctor doctor=new Doctor();
        model.addAttribute("doctor", doctor);

        return "doctor/new_form";
    }

    @GetMapping("/doctor/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id,Model model) {

        Doctor doctor = doctorService.getById(id);
        model.addAttribute("doctor",doctor);
        return "doctor/edit_form";
    }

    @PostMapping("/doctor/save")
    public String saveOrUpdateDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.save(doctor);

        return "redirect:/doctor/index";
    }

    @RequestMapping("/doctor/delete/{id}")
    public String deleteDoctorById(@PathVariable("id") Long id)
    {
        doctorService.deleteById(id);
        return "redirect:/doctor/index";

    }

    @GetMapping("/doctor/{name}")
    public String getDoctorByName(@PathVariable("name") String name,Model model) {

        List<Doctor>doctorList=doctorService.getDoctorByName(name);
        model.addAttribute("doctorList",doctorList);
        return "doctor/showByName";
    }

    @GetMapping("/doctor/{speciality}")
    public String getDoctorBySpeciality(@PathVariable("speciality") String speciality,Model model) {

        List<Doctor>doctorList=doctorService.getDoctorBySpeciality(speciality);
        model.addAttribute("doctorList",doctorList);
        return "doctor/showBySpeciality";
    }
    @GetMapping("/doctor/{symptoms}")
    public String getDoctorBySymptoms(@PathVariable("symptoms") String symptoms,Model model) {

        List<Doctor>doctorList=doctorService.getDoctorBySymptoms(symptoms);
        model.addAttribute("doctorList",doctorList);
        return "doctor/showBySymptoms";
    }


}
