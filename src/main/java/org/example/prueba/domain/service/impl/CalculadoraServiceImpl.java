package org.example.prueba.domain.service.impl;

import org.example.prueba.domain.service.ICalculadoraService;
import org.example.prueba.infrastructure.utils.Operador;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculadoraServiceImpl implements ICalculadoraService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculadoraServiceImpl.class);

    /**
     * Intentamos convertir la operación, sino podemos lanzamos un error,
     * y realizamos la operación correspondiente
     *
     * @param primerNumero
     * @param segundoNumero
     * @param tipoOperacion
     * @return El resultado dependiendo del tipo de operacion introducido
     */
    @Override
    public double calculo(BigDecimal primerNumero, BigDecimal segundoNumero, String tipoOperacion) {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculando resultado para : {} {} {}", primerNumero, segundoNumero, tipoOperacion);
        }

        Operador operador = Operador.valor(tipoOperacion);

        if (operador != null) {
            switch (operador) {
                case SUMA:
                    return primerNumero.add(segundoNumero).doubleValue();
                case RESTA:
                    return primerNumero.subtract(segundoNumero).doubleValue();
                default:
                    if (LOGGER.isErrorEnabled()) {
                        LOGGER.error("No soporta el operador: {}", operador);
                    }
                    throw new RuntimeException("No soporta el operador: " + operador.toString());
            }
        } else {
            throw new RuntimeException("No se puede procesar la operación: " + tipoOperacion);
        }
    }
}
