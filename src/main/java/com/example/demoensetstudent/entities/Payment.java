package com.example.demoensetstudent.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @Builder

public class Payment  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentType type;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String file;
    @ManyToOne
    private Student student;

}
