package org.example.alchimia.dto;

import lombok.Data;

@Data
public class PacienteRegister {
    String nome;
    String senha;
    String email;
    String CPF;
    Integer celular;
}
