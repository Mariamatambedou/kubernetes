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

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
		return args -> {
			// Création de nouveaux étudiants avec UUID pour l'ID
			Student student1 = Student.builder()
					.id(UUID.randomUUID().toString())  // Générer un ID unique
					.firstName("John")
					.lastName("Doe")
					.code("11100")
					.programId("program1")
					.photo("photo1.jpg")
					.build();

			Student student2 = Student.builder()
					.id(UUID.randomUUID().toString())  // Générer un ID unique
					.firstName("Jane")
					.lastName("Doe")
					.code("22200")
					.programId("program2")
					.photo("photo2.jpg")
					.build();

			// Sauvegarde des étudiants dans la base de données
			studentRepository.save(student1);
			studentRepository.save(student2);

			// Création des paiements associés aux étudiants
			Payment payment1 = Payment.builder()
					.date(LocalDate.of(2024, 11, 1))
					.amount(100.0)
					.type(PaymentType.CASH)  // Valeur de type d'énumération
					.status(PaymentStatus.VALIDATED)  // Valeur d'énumération
					.file("receipt1.pdf")
					.student(student1)  // Lier l'étudiant 1
					.build();

			Payment payment2 = Payment.builder()
					.date(LocalDate.of(2024, 11, 2))
					.amount(150.0)
					.type(PaymentType.TRANSFER)
					.status(PaymentStatus.CREATED)
					.file("receipt2.pdf")
					.student(student2)  // Lier l'étudiant 2
					.build();

			// Sauvegarde des paiements dans la base de données
			paymentRepository.save(payment1);
			paymentRepository.save(payment2);
		};
	}
}

