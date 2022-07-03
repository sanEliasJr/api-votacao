package com.solutis.votacao.domain.sessao.repository;

import com.solutis.votacao.domain.sessao.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
}
