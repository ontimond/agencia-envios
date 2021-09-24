package com.agencia.envios.Agencia.envios.services;

public class PaqueteNotFoundException extends RuntimeException {
    public PaqueteNotFoundException(Long id) {
        super("Could not find paquete " + id);
    }
}
