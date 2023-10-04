package com.example.doctor.Proxy;

import com.example.doctor.Model.DTO.AddPatientDTO;
import com.example.doctor.Model.DTO.AddPaymentDTO;
import com.example.doctor.Model.DTO.PatientDTO;
import com.example.doctor.Model.DTO.PaymentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="PAYMENT-SERVICE")
public interface PaymentProxy {

    @GetMapping("/payment/by-transaction/")
    PaymentDTO getPaymentByTransId(@RequestParam String transId);
    @PostMapping("/payment/")
     PaymentDTO addPayment(@RequestBody AddPaymentDTO paymentDTO);
}
