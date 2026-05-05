package org.example.alchimia.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Public")
@Table(name = "Paciente")
@Data
public class Paciente implements UserDetails {


    @Id
    @Column(name = "Codigo")
    private Long codigo;

    private String senha;

    @Column(name = "Logradouro")
    private String logradouro;

    @Column(name = "Nome")
    private String nome;

    @Column(name = "Endereco")
    private String endereco;

    @Column(name = "Numero")
    private String numero;

    @Column(name = "Bairro")
    private String bairro;

    @Column(name = "Cidade")
    private String cidade;

    @Column(name = "Estado")
    private Integer estado;

    @Column(name = "Cep")
    private String cep;

    @Column(name = "DDD1")
    private String ddd1;

    @Column(name = "Fone")
    private String fone;

    @Column(name = "DDD2")
    private String ddd2;

    @Column(name = "DDD3")
    private String ddd3;

    @Column(name = "Celular")
    private String celular;

    @Column(name = "Celular2")
    private String celular2;

    @Column(name = "Email")
    private String email;

    @Column(name = "Estciv")
    private String estciv;

    @Column(name = "Nascimento")
    private LocalDate nascimento;

    @Column(name = "Idade")
    private Integer idade;

    @Column(name = "CompIdade")
    private String compIdade;

    @Column(name = "Altura")
    private Integer altura;

    @Column(name = "Peso")
    private Integer peso;

    @Column(name = "Sexo")
    private String sexo;

    @Column(name = "Profissao")
    private String profissao;

    @Column(name = "Identidade")
    private String identidade;

    @Column(name = "OrgaoExp")
    private String orgaoExp;

    @Column(name = "DataExp")
    private LocalDate dataExp;

    @Column(name = "Cpf")
    private String cpf;

    @Column(name = "Naturalidade")
    private String naturalidade;

    @Column(name = "Responsavel")
    private String responsavel;

    @Column(name = "Pai")
    private String pai;

    @Column(name = "Mae")
    private String mae;

    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "DataCadastro")
    private LocalDate dataCadastro;

    @Column(name = "CNS")
    private String cns;

    @Column(name = "IBGE")
    private String ibge;

    @Column(name = "Especial")
    private Boolean especial;

    @Column(name = "ProfissaoPai")
    private String profissaoPai;

    @Column(name = "ProfissaoMae")
    private String profissaoMae;

    @Column(name = "Observacao")
    private String observacao;

    @Column(name = "EnvioLGPD")
    private Integer envioLGPD;

    @Column(name = "Cor")
    private String cor;

    @Column(name = "NomeSocial")
    private String nomeSocial;

    @Column(name = "NaoRecebeWhats")
    private Integer naoRecebeWhats;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }
    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
