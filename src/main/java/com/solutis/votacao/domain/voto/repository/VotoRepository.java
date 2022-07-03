package com.solutis.votacao.domain.voto.repository;

import com.solutis.votacao.domain.associado.entity.Associado;
import com.solutis.votacao.domain.voto.entity.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Associado> {

}
