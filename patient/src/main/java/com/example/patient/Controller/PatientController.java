package com.example.patient.Controller;

import com.example.patient.Model.DTO.AddPatientDTO;
import com.example.patient.Model.DTO.PatientDTO;
import com.example.patient.Model.DTO.PaymentDTO;
import com.example.patient.Model.DTO.UpdatePatientDTO;
import com.example.patient.Service.PatientPaymentService;
import com.example.patient.Service.PatientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@AllArgsConstructor
@Slf4j
public class PatientController {
    final private PatientService patientService;
    final private PatientPaymentService paymentService;
    @GetMapping("/{name}")
   public String getName(@PathVariable String name){
       return patientService.getName(name);
   }

   @PostMapping("/")
   public AddPatientDTO addPatient(@RequestBody AddPatientDTO patientDTO){

       log.info("Add patient with details {} {}",patientDTO.getPatientName(),patientDTO.getPatientAge());
       AddPatientDTO save = patientService.addPatient(patientDTO);
       log.info("Successfully saved patient details {} {}",save.getPatientName(),save.getPatientAge());
       return save;

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
        log.info("getting patient details for id {}",id);
        PatientDTO patientDetails =patientService.getPatient(id);
        log.info("Patient details {} {}",patientDetails.getPatientName(),patientDetails.getPatientAge());
        return patientDetails ;
    }

    @GetMapping("/payment/by-patientId/")
    List<PaymentDTO> getPaymentByPatientId(@RequestParam Long patientId){
        return paymentService.getPatientPayments(patientId);
    };

}
