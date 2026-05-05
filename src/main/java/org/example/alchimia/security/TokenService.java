package org.example.alchimia.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.example.alchimia.entity.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;



@Service
@RequiredArgsConstructor
public class TokenService {

    private final String chave = "nuba";
    static private final int tempoTokenEmMinuto = 60;

    public String gerarToken(Paciente paciente){
        return JWT.create()
                .withIssuer("paciente")
                .withSubject(paciente.getCpf())
                .withClaim("id", paciente.getCodigo())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(tempoTokenEmMinuto)
                        .toInstant(ZoneOffset.of("-03:00"))
                )
                .sign(Algorithm.HMAC256(chave));
    }

    public String getSubject(String token){
        return JWT.require(Algorithm.HMAC256(chave))
                .withIssuer("paciente")
                .build().verify(token).getSubject();
    }


}
