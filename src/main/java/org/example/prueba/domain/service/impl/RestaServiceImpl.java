package org.example.prueba.domain.service.impl;

import org.example.prueba.domain.service.ICalculoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RestaServiceImpl implements ICalculoService {
    @Override
    public BigDecimal calculo(BigDecimal primerNumero, BigDecimal segundoNumero) {
        return primerNumero.subtract(segundoNumero);
    }
}
