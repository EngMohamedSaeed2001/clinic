package com.example.doctor.Proxy;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="PATIENT-SERVICE")
public interface PatientProxy {
    @GetMapping("/patient/")
    PatientDTO getPatient(@RequestParam Long id);

    @PostMapping("/patient/")
    AddPatientDTO addPatient(@RequestBody AddPatientDTO patientDTO);


}
