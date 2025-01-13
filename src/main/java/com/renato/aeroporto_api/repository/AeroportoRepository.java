package com.renato.aeroporto_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renato.aeroporto_api.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
    Aeroporto findByCodigoIATA(Long codigoIATA);
}
