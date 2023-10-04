package com.example.doctor.Model.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class AddPatientDTO {

    private String patientName;
    private Integer patientAge;
}
