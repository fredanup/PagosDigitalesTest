package com.PagosDigitales.Examen.Dominio.Interfaz;

import com.PagosDigitales.Examen.Dominio.Model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;


public interface iTarea extends JpaRepository<Tarea,Long> {

}
