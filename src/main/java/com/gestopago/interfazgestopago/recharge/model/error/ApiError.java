package com.gestopago.interfazgestopago.recharge.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
}
