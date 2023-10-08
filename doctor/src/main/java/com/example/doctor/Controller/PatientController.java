package com.example.doctor.Controller;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import com.example.doctor.Service.PatientService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
@Slf4j
public class PatientController {

    private final PatientService patientService;

    @CircuitBreaker(name = "getPatientInstance",fallbackMethod = "getDefaultPatient")
    @GetMapping("/patient")
    public PatientDTO getPatientByDoctor(@RequestParam Long id){
        log.info("getting patient details by doctor for id {}",id);
        PatientDTO patientDetails =patientService.getPatientByDoctor(id);
        log.info("Patient details by doctor {} {}",patientDetails.getPatientName(),patientDetails.getPatientAge());
        return patientDetails ;
    }

    @PostMapping("/patient")
    public AddPatientDTO addPatientByDoctor(@RequestBody AddPatientDTO patientDTO){
       log.info("Add patient by doctor with details {} {}",patientDTO.getPatientName(),patientDTO.getPatientAge());
       AddPatientDTO save = patientService.addPatientByDoctor(patientDTO);
      log.info("Successfully saved patient details by doctor {} {}",save.getPatientName(), save.getPatientAge());
        return save;
    }

    public PatientDTO getDefaultPatient(Exception e){
        return PatientDTO.builder()
                .patientName("PATIENT-SERVICE is down")
                .patientAge(0)
                .build();
    }

}
