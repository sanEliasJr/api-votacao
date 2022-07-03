package com.solutis.votacao.domain.sessao.entity;

import com.solutis.votacao.domain.common.entity.BaseEntity;
import com.solutis.votacao.domain.pauta.entity.Pauta;
import com.solutis.votacao.domain.voto.entity.Voto;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.LinkedHashSet;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sessao")
public class Sessao  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "data_abertura")
    private LocalDateTime dataAbertura;

    @Column(name = "data_fechamento")
    private LocalDateTime dataFechamento;

    @OneToOne
    @JoinColumn(name = "id_pauta")
    private Pauta pauta;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sessao", cascade = CascadeType.ALL)
    private Collection<Voto> votos = new LinkedHashSet<Voto>();
}
