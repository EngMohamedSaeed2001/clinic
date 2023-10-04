package com.example.doctor.Service;

import com.example.doctor.Model.DTO.AddPaymentDTO;
import com.example.doctor.Model.DTO.PaymentDTO;
import com.example.doctor.Proxy.PaymentProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentProxy paymentProxy;


    public PaymentDTO getPaymentByDoctor(String transId){
        return paymentProxy.getPaymentByTransId(transId);
    }

    public PaymentDTO addPaymentByDoctor(AddPaymentDTO paymentDTO) {
        return paymentProxy.addPayment(paymentDTO);
    }
}
