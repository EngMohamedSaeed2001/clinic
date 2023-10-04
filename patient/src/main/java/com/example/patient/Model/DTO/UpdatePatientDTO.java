package com.example.patient.Model.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class UpdatePatientDTO {
    private Long id;
    private String patientName;
    private Integer patientAge;
}
