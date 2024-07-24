package com.gestopago.interfazgestopago.authentication.controller;

import com.gestopago.interfazgestopago.authentication.model.AltanAuthenticationResponse;
import com.gestopago.interfazgestopago.authentication.model.BBVAAuthenticationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("telefonica")
public class AuthenticationController {

    @PostMapping("/auth")
    public ResponseEntity<?> getToken( @RequestBody BBVAAuthenticationRequest request) {
        log.info("Request: {}", request);
        //TODO Call Api Altan Telefonica
        return ResponseEntity.ok(new AltanAuthenticationResponse(0, true, "Proceso de generar token ejecutado correctamente", "q6iRwR8ntMt01idBvmQLog1HONQCuijh"));
    }

}
