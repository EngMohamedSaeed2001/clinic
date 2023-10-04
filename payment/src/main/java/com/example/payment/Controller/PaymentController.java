package com.example.payment.Controller;

import com.example.payment.Model.DTO.AddPaymentDTO;
import com.example.payment.Model.DTO.PaymentDTO;
import com.example.payment.Service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
@AllArgsConstructor
public class PaymentController {
    final private PaymentService paymentService;

   @GetMapping("/by-transaction/")
    public PaymentDTO getPaymentByTransId(@RequestParam String transId){
        return paymentService.getPaymentByTransId(transId);
    }

    @PostMapping("/")
    public PaymentDTO addPayment(@RequestBody AddPaymentDTO paymentDTO){
        return paymentService.addPayment(paymentDTO);
    }

    @GetMapping("/by-patientId/")
    public List<PaymentDTO> getPaymentByPatientId(@RequestParam Long patientId){
        return paymentService.getPatientPayments(patientId);
    }
}
