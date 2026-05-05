package org.example.alchimia.dto;

import lombok.Data;

@Data
public class CadastroAtendimento {

    private Long paciente;

    private Integer convenio;
    private String matricula;
    private String plano;
    private String medico;



}
