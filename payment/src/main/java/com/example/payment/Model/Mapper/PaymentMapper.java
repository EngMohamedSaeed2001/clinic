package com.example.payment.Model.Mapper;

import com.example.payment.Model.DTO.AddPaymentDTO;
import com.example.payment.Model.DTO.PaymentDTO;
import com.example.payment.Model.Entity.Payment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentDTO toDTO(Payment payment);
   List<PaymentDTO> toDTOList(List<Payment> paymentList);
    Payment toEntity(PaymentDTO paymentDTO);


}
