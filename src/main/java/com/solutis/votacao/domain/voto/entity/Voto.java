package com.solutis.votacao.domain.voto.entity;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@ToString(exclude = "sessao")
@Table(name = "voto")
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull(message = "CPF é obrigatório.")
    @JoinColumn(name = "id_associado")
    @ManyToOne
    private Associado associado; // Como associar um associado a um voto!

    @Column(name = "data")
    private LocalDateTime dataHoraVoto;

    @NotNull(message = "Opcao de voto e obrigatório.")
    @Column(name = "opcao_voto")
    private Boolean OpcaoVoto;

    @ManyToOne
    @JoinColumn(name = "id_sessao")
    private Sessao sessao;

}
