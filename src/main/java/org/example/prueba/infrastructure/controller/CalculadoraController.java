package org.example.prueba.infrastructure.controller;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.example.prueba.domain.service.ICalculadoraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
@AllArgsConstructor
@Tag(name = "calculadora API", description = "Api que realiza operaciones aritmeticas")
public class CalculadoraController {

    private final ICalculadoraService calculadoraService;
    private final TracerImpl tracerImpl = new TracerImpl();

    @GetMapping(value = "/calcula")
    public ResponseEntity<Double> calculo(@RequestParam(name = "primero") BigDecimal primerNumero,
                                          @RequestParam(name = "segundo") BigDecimal segundoNumero,
                                          @RequestParam(name = "operacion") String operacion) {

        double result = this.calculadoraService.calculo(primerNumero, segundoNumero, operacion);
        tracerImpl.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
