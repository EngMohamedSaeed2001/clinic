package com.example.doctor.Model.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PatientDTO {

    private String patientName;
    private Integer patientAge;
}
