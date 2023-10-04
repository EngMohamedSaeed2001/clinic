package com.example.patient.Controller;

import com.example.patient.Model.DTO.AddPatientDTO;
import com.example.patient.Model.DTO.PatientDTO;
import com.example.patient.Model.DTO.PaymentDTO;
import com.example.patient.Model.DTO.UpdatePatientDTO;
import com.example.patient.Service.PatientPaymentService;
import com.example.patient.Service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
public class PatientController {
    final private PatientService patientService;
    final private PatientPaymentService paymentService;
    @GetMapping("/{name}")
   public String getName(@PathVariable String name){
       return patientService.getName(name);
   }

   @PostMapping("/")
   public AddPatientDTO addPatient(@RequestBody AddPatientDTO patientDTO){
        return patientService.addPatient(patientDTO);
   }

    @PutMapping("/")
    public PatientDTO updatePatient(@RequestBody UpdatePatientDTO patientDTO){
        return patientService.updatePatient(patientDTO);
    }

    @DeleteMapping("/")
    public void deletePatient(@RequestParam Long id){
      patientService.deletePatient(id);
    }

    @GetMapping("/")
    public PatientDTO getPatient(@RequestParam Long id){
       return patientService.getPatient(id);
    }

    @GetMapping("/payment/by-patientId/")
    List<PaymentDTO> getPaymentByPatientId(@RequestParam Long patientId){
        return paymentService.getPatientPayments(patientId);
    };

}
