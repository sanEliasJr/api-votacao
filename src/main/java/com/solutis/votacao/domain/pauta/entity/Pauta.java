package com.solutis.votacao.domain.pauta.entity;

import com.solutis.votacao.domain.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pauta")
public class Pauta extends BaseEntity {
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "descricao", length = 255)
    private String descricao;




    @Builder
    public Pauta(Long id, String nome, String descricao){
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

}
