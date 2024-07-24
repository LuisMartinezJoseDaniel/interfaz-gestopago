package com.gestopago.interfazgestopago.recharge.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "Operation")
@Table(name = "operations")
@Data
public class Operation {
    @Id
    @SequenceGenerator(
            name = "operation_sequence",
            sequenceName = "operation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "operation_sequence")
    private Long id;
    private String name;
}
