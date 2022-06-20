package com.solutis.votacao.domain.sessao.entity;

import com.solutis.votacao.domain.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sessao")
public class Sessao  extends BaseEntity {

    @Column(name = "", nullable = false)
    private String nome;

    @Builder
    public Sessao(Long id, String nome){
        this.id = id;
        this.nome = nome;
    }

}
