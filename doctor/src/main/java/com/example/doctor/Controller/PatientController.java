package com.example.doctor.Controller;

import com.example.doctor.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@AllArgsConstructor
public class PatientController {

    final private PatientService patientService;

    @GetMapping("/{name}")
    public String getPatient(@PathVariable String name){
        return patientService.getPatient(name);
    }

    @GetMapping("/feign/{name}")
    public String getPatientByFeign(@PathVariable String name){
        return patientService.getPatientByFeignClient(name);
    }

}
