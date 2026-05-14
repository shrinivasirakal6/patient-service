package com.patient_service.controller;

import com.patient_service.entity.Patient;
import com.patient_service.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    //http://localhost:8082/api/v1/patient/getpatientbyid?id=1
    @GetMapping("/getpatientbyid")
    public Patient getPatientById(@RequestParam long id){

        return patientRepository
                .findById(id)
                .get();
    }

    @PostMapping("/create")
    public Patient savePatient(
            @RequestBody Patient patient){
       return patientRepository.save(patient);
    }

}
