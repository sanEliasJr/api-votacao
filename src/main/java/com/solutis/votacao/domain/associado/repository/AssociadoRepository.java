package com.solutis.votacao.domain.associado.repository;

import com.solutis.votacao.domain.associado.entity.Associado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Long> {
}
