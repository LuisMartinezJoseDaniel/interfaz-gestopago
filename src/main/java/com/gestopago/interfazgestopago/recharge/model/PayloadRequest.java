package com.gestopago.interfazgestopago.recharge.model;

public record PayloadRequest(String beId, String offerId, String dn, String operationNumber) {
}
