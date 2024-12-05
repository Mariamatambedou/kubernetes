package com.example.demoensetstudent;

import com.example.demoensetstudent.entities.Payment;
import com.example.demoensetstudent.entities.PaymentStatus;
import com.example.demoensetstudent.entities.PaymentType;
import com.example.demoensetstudent.entities.Student;
import com.example.demoensetstudent.repository.PaymentRepository;
import com.example.demoensetstudent.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class DemoEnsetStudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEnsetStudentApplication.class, args);
	}

	}
	

