package com.gestopago.interfazgestopago.authentication.model;

public record AltanAuthenticationResponse(Integer codigo, Boolean status, String mensage, String token) {
}
