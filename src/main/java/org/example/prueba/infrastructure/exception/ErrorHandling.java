package org.example.prueba.infrastructure.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.math.BigDecimal;
import java.util.List;

@ControllerAdvice
@Slf4j
public class ErrorHandling extends ResponseEntityExceptionHandler {

    public ErrorHandling(){

    }

    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    protected ResponseEntity<BigDecimal> argumentoNoValido(ArithmeticException exception) {
        log.error("Los parametros introducidos no pueden ser 0", exception);
        return new ResponseEntity("No se puede dividir por 0", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<BigDecimal> nullPointerException(NullPointerException exception){
        log.error("Los parametros introducidos no pueden ser nulos", exception);
        return new ResponseEntity("No se puede introducir un valor como nulo", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
