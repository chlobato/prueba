package org.example.prueba.infrastructure.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public enum Operador {

    SUMA("+"),
    RESTA("-");

    private static final Operador[] tiposOperador = new Operador[]{SUMA, RESTA};

    private String signo;

    Operador(String signo) {
        this.signo = signo;
    }

    /**
     * Parsea el parametro String valor en un objeto de tipo Operacion.
     * El valor del String sera el tipo de operador pueder ser:
     * ("suma", "resta" "SUMA" "RESTA") y los operadores ( '+', '-')
     * y para futuras operaciones como ("multlipicar" y "dividir" ('*', '/')
     *
     * @param valor
     * @return El tipo de operador que se ha introducido como parametro
     */
    @JsonCreator
    public static Operador valor(String valor) {

        for (Operador num : tiposOperador
        ) {
            Operador opActual = num;
            if (valor.equalsIgnoreCase(opActual.name()) ||
                    valor.equalsIgnoreCase(opActual.getSigno())) {
                return opActual;
            }
        }

        throw new RuntimeException("Operación no soportada para el valor: " + valor);
    }
}
