package com.example.prueba.controller;

import org.example.prueba.infrastructure.controller.CalculadoraController;
import org.example.prueba.domain.service.impl.DividirServiceImpl;
import org.example.prueba.domain.service.impl.RestaServiceImpl;
import org.example.prueba.domain.service.impl.SumaServiceImpl;
import org.junit.jupiter.api.Assertions;
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
    private SumaServiceImpl suma;

    @Mock
    private RestaServiceImpl resta;

    @Mock
    private DividirServiceImpl dividir;

    @Test
    void suma() {
        Mockito.when(suma.calculo(Mockito.any(),Mockito.any())).thenReturn(BigDecimal.valueOf(12));
        ResponseEntity<BigDecimal> resultado = calculadoraController.suma(new BigDecimal(6),new BigDecimal(6));
        Assertions.assertEquals(new ResponseEntity<>(BigDecimal.valueOf(12), HttpStatus.OK),resultado);
    }

    @Test
    void resta() {
        Mockito.when(resta.calculo(Mockito.any(),Mockito.any())).thenReturn(BigDecimal.valueOf(1));
        ResponseEntity<BigDecimal> resultado = calculadoraController.resta(new BigDecimal(7),new BigDecimal(6));
        Assertions.assertEquals(new ResponseEntity<>(BigDecimal.valueOf(1), HttpStatus.OK),resultado);
    }

    @Test
    void dividir() {
        Mockito.when(dividir.calculo(Mockito.any(),Mockito.any())).thenReturn(BigDecimal.valueOf(4));
        ResponseEntity<BigDecimal> resultado = calculadoraController.dividir(new BigDecimal(8),new BigDecimal(2));
        Assertions.assertEquals(new ResponseEntity<>(BigDecimal.valueOf(4), HttpStatus.OK),resultado);
    }
}
