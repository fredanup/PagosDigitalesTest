package com.PagosDigitales.Examen.Dominio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String detalle;
    private boolean terminado;

    public Tarea(){}

    public Tarea(String detalle, boolean terminado) {
        this.detalle = detalle;
        this.terminado = terminado;
    }
}
