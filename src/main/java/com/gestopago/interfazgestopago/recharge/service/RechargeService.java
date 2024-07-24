package com.gestopago.interfazgestopago.recharge.service;

import com.gestopago.interfazgestopago.recharge.model.response.AltanResponse;
import com.gestopago.interfazgestopago.recharge.model.PayloadRequest;

public interface RechargeService {

    AltanResponse doRecharge( PayloadRequest payloadRequest );

}
