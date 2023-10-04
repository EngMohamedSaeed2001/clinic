package com.example.patient.Model.Mapper;

import com.example.patient.Model.DTO.PatientDTO;
import com.example.patient.Model.DTO.UpdatePatientDTO;
import com.example.patient.Model.Entity.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientDTO patientDTO);
    PatientDTO toDTO(Patient patient);
    Patient toUpdateEntity(UpdatePatientDTO patient);
}
