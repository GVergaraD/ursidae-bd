package com.example.demo.NotFoundE;

public class CamaNFE extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public CamaNFE(Long id) {
        super("No se encontró la cama: " + id);
    }
}
