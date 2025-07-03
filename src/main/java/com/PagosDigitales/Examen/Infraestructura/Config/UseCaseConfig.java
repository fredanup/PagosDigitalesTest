package com.PagosDigitales.Examen.Infraestructura.Config;

import com.PagosDigitales.Examen.Aplicacion.TareaUseCase;
import com.PagosDigitales.Examen.Aplicacion.UsuarioUseCase;
import com.PagosDigitales.Examen.Dominio.Interfaz.iTarea;
import com.PagosDigitales.Examen.Dominio.Interfaz.iUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public TareaUseCase instanciarTarea(iTarea tareaRepository){
        return new TareaUseCase(tareaRepository);
    }

    @Bean
    public UsuarioUseCase instanciarUsuario(iUsuario usuarioRepository){
        return new UsuarioUseCase(usuarioRepository);
    }
}
