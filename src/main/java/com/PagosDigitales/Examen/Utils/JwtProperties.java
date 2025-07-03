package com.PagosDigitales.Examen.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProperties {

    @Value("${jwt.secret}")
    private String secret;

    public String getSecret() {
        return secret;
    }
}
