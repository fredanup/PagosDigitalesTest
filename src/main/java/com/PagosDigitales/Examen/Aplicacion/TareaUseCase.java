package com.PagosDigitales.Examen.Aplicacion;

import com.PagosDigitales.Examen.Dominio.Interfaz.iTarea;
import com.PagosDigitales.Examen.Dominio.Model.Tarea;


import java.util.List;
import java.util.Optional;


public class TareaUseCase {
    private final iTarea tareaRepository;

    public TareaUseCase(iTarea tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea tarea) {
        return tareaRepository.findById(id).map(t -> {
            t.setDetalle(tarea.getDetalle());
            t.setTerminado(tarea.isTerminado());
            return tareaRepository.save(t);
        });
    }

    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
