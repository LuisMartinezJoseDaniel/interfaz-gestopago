package com.gestopago.interfazgestopago.recharge.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Data
@Getter
@Setter
@Entity(name = "Catalog")
@Table(name = "catalog")
public class Catalog {
    
    @Id
    @SequenceGenerator(
            name = "catalog_sequence",
            sequenceName = "catalog_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_sequence")
    private Long id;
    private BigInteger beId;
    private BigInteger offerId;
    private Double amount;
    private BigInteger serviceId;
    private BigInteger productId;
    
}
