package com.example.doctor.Service;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import com.example.doctor.Proxy.PatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    @Autowired
    private PatientProxy patientProxy;


    public PatientDTO getPatientByDoctor(Long id){
        return patientProxy.getPatient(id);
    }

    public AddPatientDTO addPatientByDoctor(AddPatientDTO patientDTO) {
        return patientProxy.addPatient(patientDTO);
    }
}
