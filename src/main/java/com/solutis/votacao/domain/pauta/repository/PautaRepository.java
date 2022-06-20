package com.solutis.votacao.domain.pauta.repository;

import com.solutis.votacao.domain.pauta.entity.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {

}
