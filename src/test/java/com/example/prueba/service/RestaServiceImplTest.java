package com.example.prueba.service;

import org.example.prueba.domain.service.impl.RestaServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class RestaServiceImplTest {

    @Autowired
    private RestaServiceImpl restaService;

    @BeforeEach
    public void setup() {
        restaService = new RestaServiceImpl();
    }

    @Test
    void calculoResta() {
        BigDecimal primerNumero = new BigDecimal(9);
        BigDecimal segundoNumero = new BigDecimal(8);
        BigDecimal result = restaService.calculo(primerNumero, segundoNumero);
        Assertions.assertEquals(1.0, result.doubleValue());
    }
}
