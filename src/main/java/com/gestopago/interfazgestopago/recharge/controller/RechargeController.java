package com.gestopago.interfazgestopago.recharge.controller;

import com.gestopago.interfazgestopago.amqp.producer.RabbitMQMessageProducer;
import com.gestopago.interfazgestopago.notification.configuration.NotificationConfig;
import com.gestopago.interfazgestopago.recharge.model.PayloadRequest;
import com.gestopago.interfazgestopago.recharge.model.response.AltanResponse;
import com.gestopago.interfazgestopago.recharge.model.request.BBVARequest;
import com.gestopago.interfazgestopago.recharge.model.request.BBVANotificationRequest;
import com.gestopago.interfazgestopago.recharge.service.RechargeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/telefonica")
@AllArgsConstructor
public class RechargeController {
    
    private final RechargeService rechargeService;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;
    private final NotificationConfig notificationConfig;
    
    @PostMapping("/compra")
    public ResponseEntity<AltanResponse> doRecharge (@Valid @RequestBody BBVARequest request ){
        
        log.info("Request: {}" , request);
        //TODO: Call Api Altan Telefonica
        
        var payload = new PayloadRequest("1", "123", request.dn(), request.operationNumber());
        rechargeService.doRecharge(payload);
        log.info("Payload to Super Api: {}" , payload);
        
        //TODO Get Response from Altan Telefonica
        var altanResponse = new AltanResponse(0, request.dn(), request.pesos(), "4310202753771843", true, "Proceso de recarga pesos ejecutado correctamente");
        
        //TODO Enqueue response to rabbitmq to send to Gestopago Core
        this.enqueueAltanResponseToGestopagoCore(altanResponse);
        return ResponseEntity.ok(altanResponse);
    }
    @PostMapping("/notification")
    public ResponseEntity<Object> notification ( @Valid @RequestBody BBVANotificationRequest notification ){
        log.info("BBVANotificationRequest: {}" , notification);
        //TODO Call Api Altan Telefonica
        log.info("Payload Notification: {}" , notification);
        //TODO Get Response from Altan Telefonica
        
        //TODO Enqueue response to rabbitmq to send to Gestopago Core
        log.info("Sending altanResponse to Gestopago Core: Status: OK" );
        
        return ResponseEntity.ok(null);
    }
    
    private void enqueueAltanResponseToGestopagoCore(AltanResponse altanResponse) {
        log.info("Sending altanResponse to Gestopago Core: {}" , altanResponse);
        try {
            rabbitMQMessageProducer.publish(
                    altanResponse,
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey()
            );
            
        }catch ( Exception e ) {
            log.error( "Error al enviar mensaje a la cola de notificaciones internas: {}", e.getMessage() );
        }
    }

}
