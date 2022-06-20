package com.solutis.votacao.domain.common.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @CreatedDate
    @Column(name = "criado_em")
    protected LocalDateTime dtCadastro;

    @LastModifiedDate
    @Column(name = "atualizado_em")
    protected LocalDateTime dtAtualizacao;
}
