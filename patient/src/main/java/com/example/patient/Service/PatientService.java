package com.example.patient.Service;

import com.example.patient.Model.DTO.AddPatientDTO;
import com.example.patient.Model.DTO.PatientDTO;
import com.example.patient.Model.DTO.UpdatePatientDTO;
import com.example.patient.Model.Entity.Patient;
import com.example.patient.Model.Mapper.PatientMapper;
import com.example.patient.Repository.PatientRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PatientService {
    final private PatientRepo patientRepo;
    @Autowired
    PatientMapper patientMapper;
    public String getName(String name){
        return name;
    }

    public AddPatientDTO addPatient(AddPatientDTO patientDTO){
     Patient patient= Patient.builder()
                .patientName(patientDTO.getPatientName())
                .patientAge(patientDTO.getPatientAge())
                .build();

     Patient res = patientRepo.save(patient);

     return AddPatientDTO.builder()
             .patientName(res.getPatientName())
             .patientAge(res.getPatientAge())
             .build();
    }

    public PatientDTO updatePatient(UpdatePatientDTO patientDTO) {


        Patient patient =  patientMapper.toUpdateEntity(patientDTO);

        Patient res = patientRepo.save(patient);

        return patientMapper.toDTO(res);
    }

    public void deletePatient(Long id) {
        patientRepo.deleteById(id);
    }

    public PatientDTO getPatient(Long id) {
       Optional<Patient> entity=  patientRepo.findById(id);
       if(entity.isPresent()){
           Patient patient =entity.get();
           return patientMapper.toDTO(patient);
       }else
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Patient not found");
    }
}
