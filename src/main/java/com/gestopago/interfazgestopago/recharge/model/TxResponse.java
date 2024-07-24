package com.gestopago.interfazgestopago.recharge.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity(name = "TxResponse")
@Table(name = "tx_responses")
public class TxResponse {
    
    @Id
    @SequenceGenerator(
            name = "tx_response_sequence",
            sequenceName = "tx_response_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tx_response_sequence")
    private Long id;
    private Boolean enqueueStatus;
    private Boolean status_api_altan;
    private Double amount;
    private String phone;
    @Column(nullable = true)
    private String orderIdAltan;
    @Column(columnDefinition = "json")
    private String request;
    @Column(columnDefinition = "json")
    private String response;
    
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "catalog_id",
            referencedColumnName = "id"
    )
    private Catalog catalog;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "operation_id",
            referencedColumnName = "id"
    )
    private Operation operation;
}
