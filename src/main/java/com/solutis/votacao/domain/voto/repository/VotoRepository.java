package com.solutis.votacao.domain.voto.repository;

import com.solutis.votacao.domain.voto.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    @Query(value = "Select v from Voto v where v.sessao.Id = :idSessao and v.Associado.id = :idAssociado ")
    Optional<Voto> existsBySessaoAndIdAssociado(@Param("idSessao")  Long idSessao, @Param("idAssociado") Long idAssociado);
}
