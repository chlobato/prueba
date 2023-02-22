package com.example.prueba.service;

import org.example.prueba.domain.service.impl.SumaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class SumaServiceImplTest {

    @Autowired
    private SumaServiceImpl sumaService;

    @BeforeEach
    public void setup(){
        sumaService = new SumaServiceImpl();
    }
    @Test
    void calculoSuma(){
        BigDecimal primerNumero = new BigDecimal(8);
        BigDecimal segundoNumero = new BigDecimal(8);
        BigDecimal result = sumaService.calculo(primerNumero, segundoNumero);
        Assertions.assertEquals(16.0, result.doubleValue());
    }
}
