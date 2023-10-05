package com.example.doctor.Controller;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import com.example.doctor.Service.PatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class PatientController {

    final private PatientService patientService;

    @CircuitBreaker(name = "getPatientInstance",fallbackMethod = "getDefaultPatient")
    @GetMapping("/patient")
    public PatientDTO getPatientByDoctor(@RequestParam Long id){
        return patientService.getPatientByDoctor(id);
    }

    @PostMapping("/patient")
    public AddPatientDTO addPatientByDoctor(@RequestBody AddPatientDTO patientDTO){
        return patientService.addPatientByDoctor(patientDTO);
    }

    public PatientDTO getDefaultPatient(Exception e){
        return PatientDTO.builder()
                .patientName("PATIENT-SERVICE is down")
                .patientAge(0)
                .build();
    }

}
