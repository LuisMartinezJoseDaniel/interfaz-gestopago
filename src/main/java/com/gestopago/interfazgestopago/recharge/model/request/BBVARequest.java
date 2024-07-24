package com.gestopago.interfazgestopago.recharge.model.request;

import com.gestopago.interfazgestopago.recharge.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;

public record BBVARequest(
        @NotBlank(message = "mt es requerido")
        String mt,
        @NotBlank
        @PhoneNumber(message = "dn debe ser un número de teléfono válido de 10 dígitos")
        String dn,
        @NotBlank(message = "pesos es requerido")
        String pesos,
        @NotBlank(message = "purchaseId es requerido")
        String purchaseId,
        @NotBlank(message = "purchaseDate es requerido")
        String purchaseDate,
        @NotBlank(message = "time es requerido")
        String time,
        @NotBlank(message = "operationNumber es requerido")
        String operationNumber) {
}