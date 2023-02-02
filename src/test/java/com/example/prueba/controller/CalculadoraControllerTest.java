package com.example.prueba.controller;

import org.example.prueba.domain.service.ICalculadoraService;
import org.example.prueba.infrastructure.controller.CalculadoraController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class CalculadoraControllerTest {

    @InjectMocks
    private CalculadoraController calculadoraController;

    @Mock
    private ICalculadoraService calculadoraService;

    @BeforeEach
    void setup(){
        Mockito.when(calculadoraService.calculo(Mockito.any(),Mockito.any(),Mockito.anyString())).thenReturn(12.0);
    }

    @Test
    void calculo() {
        ResponseEntity<Double> resultado = calculadoraController.calculo(new BigDecimal(6),new BigDecimal(6),"suma");
        Assertions.assertEquals(new ResponseEntity<>(12.0, HttpStatus.OK),resultado);
    }
}
