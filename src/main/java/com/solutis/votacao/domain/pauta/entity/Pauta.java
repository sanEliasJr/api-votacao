package com.solutis.votacao.domain.pauta.entity;

import com.solutis.votacao.domain.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "TB_PAUTA")
public class Pauta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;


}
