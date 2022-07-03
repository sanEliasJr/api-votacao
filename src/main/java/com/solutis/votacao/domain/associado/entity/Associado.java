package com.solutis.votacao.domain.associado.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Entity
@Table(name = "tb_associado")
public class Associado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "CPF e obrigatorio")
    @Column(name = "cpf_associado")
    private Integer cpf;

    @Column(name = "nome_associado")
    private String nome;

    @Column(name = "login_associado") //analizar possivel utilização ( CPF ou login?)
    private String login;

    @Column(name = "senha_associado")
    private Integer senha;

}
