package org.example.alchimia.entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Setor")
@Schema(name = "Public")
@AllArgsConstructor
@NoArgsConstructor
public class Setor {

    @Id
    private Integer Codigo;
    private String Nome;
    private Integer GuiaTISS;
    private Integer AplicaRedutor;

}
