package com.PagosDigitales.Examen.Dominio.Interfaz;


import com.PagosDigitales.Examen.Dominio.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iUsuario extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByEmailAndContrasena(String email, String contrasena);

}
