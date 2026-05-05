package org.example.alchimia.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "public")
@Table(name = "Atendimento")
public class Atendimento {

    @Id
    private Long requisicao;

    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "Codigo")
    private Paciente paciente;

    private Integer convenio;
    private Integer servico;
    private String matricula;
    private String plano;
    private String medico;
    private String fechamento;
    private Integer status;

    private LocalDateTime dataReal;
    private LocalDateTime hora;
    private LocalDateTime data;
    private LocalDateTime dataCadastro;
    private LocalDateTime horaCadastro;
    private Integer posto;


}
