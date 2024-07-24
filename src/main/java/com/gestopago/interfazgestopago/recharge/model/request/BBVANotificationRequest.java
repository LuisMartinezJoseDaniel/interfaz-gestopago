package com.gestopago.interfazgestopago.recharge.model.request;

import com.gestopago.interfazgestopago.recharge.validator.PhoneNumber;
import jakarta.validation.constraints.NotBlank;

public record BBVANotificationRequest(
        @NotBlank
        String mt,
        @NotBlank
        @PhoneNumber(message = "dn debe ser un número de teléfono válido de 10 dígitos")
        String dn,
        @NotBlank
        String pesos,
        @NotBlank
        String status,
        @NotBlank
        String purchaseId,
        @NotBlank
        String purchaseDate,
        @NotBlank
        String time,
        @NotBlank
        String operationNumber
) {
}

