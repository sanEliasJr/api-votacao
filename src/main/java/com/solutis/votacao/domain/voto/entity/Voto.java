package com.solutis.votacao.domain.voto.entity;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "voto")
public class Voto implements Serializable {

    @NotNull(message = "CPF é obrigatório.")
    @JoinColumn(name = "id_associado")
    @Id
    private Associado cpfAssociado;

    @Column(name = "data")
    private LocalDateTime dataHoraVoto;

    @NotNull(message = "Opcao de voto e obrigatório.")
    @Column(name = "opcao_voto")
    private Boolean OpcaoVoto;

    @ManyToOne
    @JoinColumn(name = "id_sessao_votacao")
    private Sessao sessaoVotacao;

}
