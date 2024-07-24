package com.gestopago.interfazgestopago.recharge.model.response;

public record AltanResponse(Integer codigo, String numero, String pesosRecarga, String orderId, Boolean success, String mensaje) {
}
