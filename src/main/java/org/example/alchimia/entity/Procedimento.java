package org.example.alchimia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Procedimento")
@Schema(name = "Public")
@AllArgsConstructor
@NoArgsConstructor
public class Procedimento {

    @Id
    @Column(name = "Codigo")
    private String codigo;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "NomeOld")
    private String nomeOld;

    @Column(name = "MnemoText")
    private String mnemoText;

    @Column(name = "Mnemonico")
    private String mnemonico;

    @ManyToOne
    @JoinColumn(name = "Setor", referencedColumnName = "Codigo")
    private Setor setor;

    @Column(name = "Grupo")
    private String grupo;

    @Column(name = "EmiteLau")
    private Integer emiteLau;

    @Column(name = "Entrega")
    private Integer entrega;

    @Column(name = "ExgRealizante")
    private Integer exgRealizante;

    @Column(name = "LaudoCalc")
    private Integer laudoCalc;

    @Column(name = "Borrao")
    private Integer borrao;

    @Column(name = "BloqRealizante")
    private Integer bloqRealizante;

    @Column(name = "OrdImp")
    private Integer ordImp;

    @Column(name = "PosicaoTISS")
    private Integer posicaoTISS;

    @Column(name = "SolicTISS")
    private String solicTISS;

    @Column(name = "OrdemSolicTISS")
    private Integer ordemSolicTISS;

    @Column(name = "Inativo")
    private Integer inativo;

    @Column(name = "MostraEvolucao")
    private Integer mostraEvolucao;

    @Column(name = "CentroCusto")
    private String centroCusto;

}
