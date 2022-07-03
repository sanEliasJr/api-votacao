package com.solutis.votacao.domain.pauta.entity;

import com.solutis.votacao.domain.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_pauta")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_pauta")
    private String nome;

    @Column(name = "descricao_pauta")
    private String descricao;


}
