package com.example.demoappv2.controller;

import com.example.demoappv2.repository.Patient;
import com.example.demoappv2.service.PatientService;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@RestController
@RequestMapping("/patients")
public class PatientController {
    Logger log = LoggerFactory.getLogger(PatientController.class);

    //2 dependedncia
    private final Faker faker= new Faker(new Locale("es"));
    private final Random random = new Random();

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        log.info("aqui estamos con una peticion");
        return patientService.getAllPatients();
    }

    @PostMapping("/fake")
    public Patient creationNewPatien(){
        Patient patient = new Patient();
        patient.setFullName(faker.name().fullName());
        patient.setDocument(faker.number().digits(8));
        patient.setAge(18*random.nextInt(70));
        patient.setGender(random.nextBoolean()?"M":"F");

        this.patientService.saveOnePatient(patient);
        return patient;
    }
}
