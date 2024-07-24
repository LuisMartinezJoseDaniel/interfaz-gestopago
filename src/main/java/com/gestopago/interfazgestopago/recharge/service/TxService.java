package com.gestopago.interfazgestopago.recharge.service;

import com.gestopago.interfazgestopago.recharge.model.TxResponse;

public interface TxService {
    TxResponse save( TxResponse txResponse );
}
