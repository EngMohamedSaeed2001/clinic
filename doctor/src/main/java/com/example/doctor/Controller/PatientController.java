package com.example.doctor.Controller;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import com.example.doctor.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class PatientController {

    final private PatientService patientService;


    @GetMapping("/patient")
    public PatientDTO getPatientByDoctor(@RequestParam Long id){
        return patientService.getPatientByDoctor(id);
    }

    @PostMapping("/patient")
    public AddPatientDTO addPatientByDoctor(@RequestBody AddPatientDTO patientDTO){
        return patientService.addPatientByDoctor(patientDTO);
    }


}
