package org.example.alchimia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "public")
@Table(name = "Especialidade")
public class Especialidade {

    @Id
    private Integer codigo;
    private String nome;
    private String Cbos;
    private String CbosN;
    private String Cbos3;
    private Integer PrazoRetorno;

    @Column(name = "setor_id")
    private Integer setorId;


}
