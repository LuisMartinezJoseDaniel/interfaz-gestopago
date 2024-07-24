package com.gestopago.interfazgestopago.recharge.repository;

import com.gestopago.interfazgestopago.recharge.model.TxResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TxRepository extends JpaRepository<TxResponse, Long> {
}
