package org.example.alchimia.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "public")
@Table(name = "Agenda")
public class Agenda {

    @Id
    private Integer codigo;
    private String nome;
    private Integer permissao;

    @ManyToOne
    @JoinColumn(name = "Crm", referencedColumnName = "Crm")
    private Medico Crm;

    @ManyToOne
    @JoinColumn(name = "Especialidade", referencedColumnName = "Codigo")
    private Especialidade Especialidade;

    private Integer inativo;

}
