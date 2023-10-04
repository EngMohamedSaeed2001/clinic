package com.example.doctor.Controller;

import com.example.doctor.Model.DTO.AddPaymentDTO;
import com.example.doctor.Model.DTO.PaymentDTO;
import com.example.doctor.Service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PatientPaymentDoctor {
    final private PaymentService paymentService;

    @GetMapping("/by-transaction/")
    public PaymentDTO getPaymentByTransId(@RequestParam String transId){
        return paymentService.getPaymentByDoctor(transId);
    }

    @PostMapping("/")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO paymentDTO){
        return paymentService.addPaymentByDoctor(paymentDTO);
    }
}
