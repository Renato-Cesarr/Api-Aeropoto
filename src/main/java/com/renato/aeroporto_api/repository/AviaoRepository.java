package com.renato.aeroporto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renato.aeroporto_api.model.Aviao;

@Repository
public interface AviaoRepository extends JpaRepository<Aviao, Long> {
}

