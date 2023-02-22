package com.example.prueba.service;

import org.example.prueba.domain.service.impl.DividirServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class DividirServiceImplTest {

    @Autowired
    private DividirServiceImpl dividirService;

    @BeforeEach
    public void setup() {
        dividirService = new DividirServiceImpl();
    }

    @Test
    void calculoDividir() {
        BigDecimal primerNumero = new BigDecimal(8);
        BigDecimal segundoNumero = new BigDecimal(2);
        BigDecimal result = dividirService.calculo(primerNumero, segundoNumero);
        Assertions.assertEquals(4.0, result.doubleValue());
    }
}
