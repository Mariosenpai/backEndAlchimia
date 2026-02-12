package org.example.alchimia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Exame")
@Schema(name = "Public")
@AllArgsConstructor
@NoArgsConstructor
public class Exame {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String requisicao;
    private Integer ordem;

    @ManyToOne
    @JoinColumn(name = "mnemonico", referencedColumnName = "mnemonico")
    private Procedimento mnemonico;

    @ManyToOne
    @JoinColumn(name = "priRealizante", referencedColumnName = "Crm")
    private Medico priRealizante;

    private Integer qtd;
    private String guia;

    private LocalDate data;
    private String cirurgiao;


    private String segRealizante;
    private String terRealizante;

    @Column(name = "CodInstrumentador")
    private Integer codInstrumentador;

    @Column(name = "CodAnestesista")
    private Integer codAnestesista;
    private String tecnico;

    private String viaAcesso;
    private String acomodacao;
    private String urgencia;

    private String honorarios;
    private BigDecimal valHonorarios;

    private String custoOper;
    private BigDecimal valCustoOper;

    private String filme;
    private BigDecimal valFilme;

    private String auxiliares;

    private String hon1Aux;
    private BigDecimal val1Aux;

    private String hon2Aux;
    private BigDecimal val2Aux;

    private String hon3Aux;
    private BigDecimal val3Aux;

    private String instrumentador;
    private BigDecimal valInstrumentador;

    private String anestesista;
    private BigDecimal valAnestesista;

    private String situacao;
    private BigDecimal valor;

    private String senha;
    private BigDecimal total;
    private BigDecimal desconto;
    private BigDecimal estorno;

    private Boolean fechado;

    private String tipoGuia;
    private LocalDate dataRealizacao;

    private String tecnicaTISS;
    private String viaAcessoTISS;
    private String reducaoAcrescimoTISS;

    private String olho;

    private Integer liberado;

    private LocalDate horaTecnico;
    private LocalDate horaFimExame;

    private Integer cancelado;

    private String loteFechamento;
    private String usuarioRealizacao;

    private LocalDate dataEntrega;
    private String usuarioEntrega;

    private String usuarioInclusao;
    private LocalDate dataInclusao;
    private LocalDateTime horaInclusao;

    private LocalDateTime horaExame;

    private LocalDate dataImpressao;
    private String usuarioImpressao;

    private Integer comprovanteImpresso;
    private Integer exameEncerrado;
    private Integer pendenciaGuia;

}
