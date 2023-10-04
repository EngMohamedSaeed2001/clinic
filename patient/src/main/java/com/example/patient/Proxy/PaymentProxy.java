package com.example.patient.Proxy;

import com.example.patient.Model.DTO.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "PAYMENT-SERVICE",path = "/payment")
public interface PaymentProxy {
    @GetMapping("/payment/by-patientId/")
     List<PaymentDTO> getPaymentByPatientId(@RequestParam Long patientId);
}
