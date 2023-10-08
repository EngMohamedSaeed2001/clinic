package com.example.patient.Service;

import com.example.patient.Model.DTO.PaymentDTO;
import com.example.patient.Proxy.PaymentProxy;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientPaymentService {
    @Autowired
    private PaymentProxy paymentProxy;

    public List<PaymentDTO> getPatientPayments(Long patientId){
       return paymentProxy.getPaymentByPatientId(patientId);
    }


}
