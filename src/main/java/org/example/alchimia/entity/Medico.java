package org.example.alchimia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Medico")
@Schema(name = "Public")
@AllArgsConstructor
@NoArgsConstructor
public class Medico {


    @Id
    @Column(name = "Crm")
    private String crm;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "NomeCompleto")
    private String nomeCompleto;

    @Column(name = "NomeGuerra")
    private String nomeGuerra;

    @Column(name = "Realizante")
    private Boolean realizante;

    @Column(name = "Medcasa")
    private Boolean medcasa;

    @Column(name = "Plantonista")
    private Boolean plantonista;

    @Column(name = "PorcExame")
    private BigDecimal porcExame;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Bairro")
    private String bairro;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Cep")
    private String cep;

    @Column(name = "Fone")
    private String fone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Email")
    private String email;

    @Column(name = "Unimed")
    private String unimed;

    @Column(name = "Especialidade")
    private String especialidade;

    @Column(name = "Cpf")
    private String cpf;

    @Column(name = "Amil")
    private String amil;

    @Column(name = "Conselho")
    private String conselho;

    @Column(name = "UFConselho")
    private String ufConselho;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Inativo")
    private Integer inativo;

    @Column(name = "Admissao")
    private LocalDate admissao;

    @Column(name = "Nascimento")
    private LocalDate nascimento;

    @Column(name = "Idade")
    private Integer idade;

    @Column(name = "CNS")
    private String cns;

    @Column(name = "OffsetReceita")
    private Integer offsetReceita;

    @Column(name = "Celular")
    private String celular;

    @Column(name = "RQE")
    private String rqe;

    @Column(name = "CodigoConselho")
    private String codigoConselho;

    @Column(name = "DDD")
    private String ddd;

    @Column(name = "Pix")
    private String pix;

    @Column(name = "Agencia")
    private String agencia;

    @Column(name = "Conta")
    private String conta;

    @Column(name = "Banco")
    private String banco;

    @Column(name = "TipoChave")
    private String tipoChave;

    @Column(name = "Chave")
    private String chave;

}
