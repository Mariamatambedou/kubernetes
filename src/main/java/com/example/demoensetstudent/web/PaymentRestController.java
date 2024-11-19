package com.example.demoensetstudent.web;

import com.example.demoensetstudent.entities.Payment;
import com.example.demoensetstudent.entities.PaymentStatus;
import com.example.demoensetstudent.entities.PaymentType;
import com.example.demoensetstudent.entities.Student;
import com.example.demoensetstudent.repository.PaymentRepository;
import com.example.demoensetstudent.repository.StudentRepository;
import com.example.demoensetstudent.service.PaymentService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
public class PaymentRestController {
    private StudentRepository studentRepository;
    private PaymentRepository paymentRepository;
    private PaymentService paymentService;

    public PaymentRestController(StudentRepository studentRepository, PaymentRepository paymentRepository, PaymentService paymentService) {
        this.studentRepository = studentRepository;
        this.paymentRepository = paymentRepository;
        this.paymentService = paymentService;
    }

    @GetMapping("/api/payments")
    public List<Payment> allPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/api/students/{code}/payments")
    public List<Payment> paymentByStudent(@PathVariable String code) {
        return paymentRepository.findByStudentCode(code);
    }

    @GetMapping("/api/payments/byStatus")
    public List<Payment> paymentByStatus(@RequestParam PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }

    @GetMapping("/api/payments/byType")
    public List<Payment> paymentByType(@RequestParam PaymentType type) {
        return paymentRepository.findByType(type);
    }

    @GetMapping("/api/payments/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id).get();
    }

    @GetMapping("/api/students")
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/api/students/{code}")
    public Student getStudentById(@PathVariable String code) {
        return studentRepository.findByCode(code);
    }

    @GetMapping("/api/studentsByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId) {
        return studentRepository.findByProgramId(programId);
    }

    @PutMapping("/api/payments/{id}")
    public Payment updatePaymentStatus(@RequestParam PaymentStatus status, @PathVariable Long id) {
        return paymentService.updatePaymentStatus(status, id);
    }

    @PostMapping(path = "/api/payments", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam MultipartFile file, LocalDate date, double amount, PaymentType type, String studentCode) throws IOException {

        return this.paymentService.savePayment(file, date, amount, type, studentCode);

    }

    @GetMapping(value = "/api/paymentFile/{paymentId}", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long paymentId) throws IOException {
        return paymentService.getPaymentFile(paymentId);
    }
}
