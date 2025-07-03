package com.PagosDigitales.Examen.Interfaz.Controller;

import com.PagosDigitales.Examen.Aplicacion.UsuarioUseCase;
import com.PagosDigitales.Examen.Dominio.Model.Usuario;
import com.PagosDigitales.Examen.Interfaz.Dto.LoginRequest;
import com.PagosDigitales.Examen.Utils.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final UsuarioUseCase usuarioUseCase;
    private final JwtProperties jwtProperties;

    public AuthController(UsuarioUseCase usuarioUseCase, JwtProperties jwtProperties) {
        this.usuarioUseCase = usuarioUseCase;
        this.jwtProperties = jwtProperties;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioUseCase.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        boolean estaValidado = usuarioUseCase.validarUsuario(loginRequest.getEmail(),loginRequest.getContrasena());
        if (estaValidado){
            String jwt = Jwts.builder()
                    .setSubject(loginRequest.getEmail())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1 hora
                    .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecret())
                    .compact();
            return ResponseEntity.ok(jwt);
        }
        else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }
}
