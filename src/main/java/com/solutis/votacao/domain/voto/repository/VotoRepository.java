package com.solutis.votacao.domain.voto.repository;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.sessao.entity.Sessao;
import com.solutis.votacao.domain.voto.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query("Select v from Voto v where v.sessao.Id = :idSessao and v.associado.id = :idAssociado")
    Optional<Voto> existsBySessaoAndIdAssociado(@Param("idSessao")  Long idSessao, @Param("idAssociado") Long idAssociado);
}
