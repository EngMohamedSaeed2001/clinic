package com.example.payment.Service;

import com.example.payment.Model.DTO.AddPaymentDTO;
import com.example.payment.Model.DTO.PaymentDTO;
import com.example.payment.Model.Entity.Payment;
import com.example.payment.Model.Mapper.PaymentMapper;
import com.example.payment.Repository.PaymentRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PaymentService {
   final private PaymentRepo paymentRepo;
   @Autowired
    PaymentMapper paymentMapper;

   public PaymentDTO getPaymentByTransId(String transID){
      Optional<Payment> payment=  paymentRepo.findByTransactionId(transID);
      return paymentMapper.toDTO(payment.get());
   }

    public PaymentDTO addPayment(AddPaymentDTO addPaymentDTO) {
      PaymentDTO paymentDTO = PaymentDTO.builder()
               .amount(addPaymentDTO.getAmount())
               .patientId(addPaymentDTO.getPatientId())
               .transactionId(UUID.randomUUID().toString())
               .build();
      Payment payment = paymentMapper.toEntity(paymentDTO);

     Payment res= paymentRepo.save(payment);

      return paymentMapper.toDTO(res);
    }

    public List<PaymentDTO> getPatientPayments(Long patientId){
       List<Payment> paymentList = paymentRepo.findAllByPatientId(patientId);

        return paymentMapper.toDTOList(paymentList);
   }


}
