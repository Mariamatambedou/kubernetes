package com.example.demoensetstudent.repository;

import com.example.demoensetstudent.entities.Payment;
import com.example.demoensetstudent.entities.PaymentStatus;
import com.example.demoensetstudent.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByStudentCode(String code);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByType(PaymentType type);
}
