package com.PagosDigitales.Examen.Interfaz.Dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String contrasena;
}
