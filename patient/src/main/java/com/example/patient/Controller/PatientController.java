package com.example.patient.Controller;

import com.example.patient.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    final private PatientService patientService;

    @GetMapping("/{name}")
   public String getName(@PathVariable String name){
       return patientService.getName(name);
   }
}
