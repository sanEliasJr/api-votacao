package com.solutis.votacao.domain.associado.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

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
