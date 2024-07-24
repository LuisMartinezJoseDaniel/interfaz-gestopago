package com.gestopago.interfazgestopago.recharge.service;

import com.gestopago.interfazgestopago.amqp.producer.RabbitMQMessageProducer;
import com.gestopago.interfazgestopago.notification.configuration.NotificationConfig;
import com.gestopago.interfazgestopago.recharge.model.PayloadRequest;
import com.gestopago.interfazgestopago.recharge.model.response.AltanResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class RechargeServiceImpl implements RechargeService{
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final NotificationConfig notificationConfig;
    
    @Override
    public AltanResponse doRecharge( PayloadRequest payloadRequest ) {
        
        
        return null;
    }
}
