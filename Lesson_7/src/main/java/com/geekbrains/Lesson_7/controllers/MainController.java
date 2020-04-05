package com.geekbrains.Lesson_7.controllers;

import com.geekbrains.Lesson_7.entities.Patient;
import com.geekbrains.Lesson_7.services.DoctorService;
import com.geekbrains.Lesson_7.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private PatientService patientService;

    private DoctorService doctorService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String getAllDoctors(Model model) {
        model.addAttribute("doctors", doctorService.getAllDoctors());
        return "doctors";
    }

    @GetMapping("/patients")
    public String getAllPatient(Model model) {
        model.addAttribute("patients", patientService.getAllPatients());
        return "patients";
    }
}
