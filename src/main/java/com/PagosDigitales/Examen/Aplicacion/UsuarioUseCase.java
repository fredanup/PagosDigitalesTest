package com.PagosDigitales.Examen.Aplicacion;

import com.PagosDigitales.Examen.Dominio.Interfaz.iUsuario;
import com.PagosDigitales.Examen.Dominio.Model.Tarea;
import com.PagosDigitales.Examen.Dominio.Model.Usuario;

import java.util.Optional;

public class UsuarioUseCase {
    private final iUsuario usuarioRepository;

    public UsuarioUseCase(iUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean validarUsuario(String email, String contrasena){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndContrasena(email, contrasena);
        if (usuario.isPresent()) {
            return true;
        } else {
            return false;
        }

    }
}
