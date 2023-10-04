package com.example.payment.Repository;

import com.example.payment.Model.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Long> {

    Optional<Payment> findByTransactionId(String transId);
    List<Payment> findAllByPatientId(Long patientId);
}
