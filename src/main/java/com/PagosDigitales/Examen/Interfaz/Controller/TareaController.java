package com.PagosDigitales.Examen.Interfaz.Controller;

import com.PagosDigitales.Examen.Aplicacion.TareaUseCase;
import com.PagosDigitales.Examen.Dominio.Model.Tarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/task")
public class TareaController {

    private final TareaUseCase tareaUseCase;

    public TareaController(TareaUseCase tareaUseCase) {
        this.tareaUseCase = tareaUseCase;
    }

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
        Tarea nuevaTarea = tareaUseCase.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTarea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Tarea>> actualizarTarea(@PathVariable Long id,@RequestBody Tarea tarea){
        Optional<Tarea> tareaElegida = tareaUseCase.actualizarTarea(id,tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaElegida);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas(){
        List<Tarea> tareas = tareaUseCase.listarTareas();
        return ResponseEntity.ok(tareas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTarea(@PathVariable Long id){
        tareaUseCase.eliminarTarea(id);
        return ResponseEntity.ok("Registro eliminado exitosamente");
    }
}
