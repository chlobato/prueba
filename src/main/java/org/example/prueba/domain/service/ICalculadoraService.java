package org.example.prueba.domain.service;

import java.math.BigDecimal;

/**
 * Interface that manage the operations for price
 */
public interface ICalculadoraService {

    /**
     * Este método es usado para calcular dado unos numero y el operador.
     * Realiza un calculo con los números proporcionados como parametros y el tipo de operador que se quiera hacer.
     *
     * @param primerNumero
     * @param segundoNumero
     * @param tipoOperacion sumar, restar...
     * @return Resultado de la operación.
     *
     */

    double calculo(BigDecimal primerNumero, BigDecimal segundoNumero, String tipoOperacion);
}
