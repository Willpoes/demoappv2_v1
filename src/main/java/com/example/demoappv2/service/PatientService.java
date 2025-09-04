package com.example.demoappv2.service;

import com.example.demoappv2.repository.Patient;
import com.example.demoappv2.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PatientService {
    //trazas<-
    Logger log = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    private PatientRepository patientRepository;

    //trazabilidad?

    //<-
    public List<Patient> getAllPatients(){
        log.info("aqui estamos en els ervice");
        List<Patient> resultPatient = patientRepository.findAll();
        return resultPatient;
    }

    //guardar
    public void saveOnePatient(Patient patient){
        this.patientRepository.save(patient);
        //
        log.info("aqui se guarda paciente ->", patient);
    }
}
