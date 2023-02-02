package com.example.prueba.service;

import org.example.prueba.domain.service.impl.CalculadoraServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

class CalculadoraServiceITest {

    @Autowired
    private CalculadoraServiceImpl calculadoraService;


    @BeforeEach
    public void setUp(){
        calculadoraService = new CalculadoraServiceImpl();
    }

    @Test
    void calculoSuma() {
        Double result = calculadoraService.calculo(new BigDecimal(6),new BigDecimal(6),"suma");
        Assertions.assertEquals(12.0,result);
    }

    @Test
    void calculoResta() {
        Double result = calculadoraService.calculo(new BigDecimal(7),new BigDecimal(6),"resta");
        Assertions.assertEquals(1.0,result);
    }

}
