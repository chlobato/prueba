package org.example.prueba.infrastructure.controller;

import io.corp.calculator.TracerImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
@RequestMapping("/calculadora")
@AllArgsConstructor
@Tag(name = "Calculadora API", description = "Api que realiza operaciones aritmeticas")
public class CalculadoraController {

    private final ICalculadoraService calculadoraService;
    private final TracerImpl tracerImpl = new TracerImpl();

    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Devuelve el resultado"),
                    @ApiResponse(responseCode = "500", description = "Si el operador no es valido")})
    @GetMapping(value = "/calculo")
    public ResponseEntity<BigDecimal> calculo(@RequestParam(name = "primero") BigDecimal primerNumero,
                                          @RequestParam(name = "segundo") BigDecimal segundoNumero,
                                          @RequestParam(name = "operador") String operador) {

        BigDecimal result = this.calculadoraService.calculo(primerNumero, segundoNumero, operador);
        tracerImpl.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
