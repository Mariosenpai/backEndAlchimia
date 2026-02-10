package org.example.alchimia.controller;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.example.alchimia.dto.PacienteRegister;
import org.example.alchimia.entity.Paciente;
import org.example.alchimia.entity.PacienteLogin;
import org.example.alchimia.security.TokenService;
import org.example.alchimia.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/paciente")
@Transactional
public class PacienteController {

    private final PacienteService pacienteService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @PostMapping("/registrar")
    public ResponseEntity<String> registrateUser(@RequestBody PacienteRegister user){
        return new ResponseEntity<>(pacienteService.registerPaciente(user), HttpStatus.OK);
    }


    @PostMapping("/login")
    public String login(@RequestBody PacienteLogin login){

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                login.getCpf(), login.getSenha());

        Authentication auth = authenticationManager.authenticate(token);

        Paciente paciente = (Paciente) auth.getPrincipal();

        return tokenService.gerarToken(paciente);

    }



}
