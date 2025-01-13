package com.renato.aeroporto_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.repository.AviaoRepository;

@Service
public class AeroportoService {

    @Autowired
    private AviaoRepository aviaoRepository;

    public List<Aviao> buscarTodos() {
        return aviaoRepository.findAll();
    }

    public Aviao buscarPorId(Long id) {
        return aviaoRepository.findById(id).orElse(null);
    }
    
    public List<Aviao> salvarTodos(List<Aviao> avioes) {
        return aviaoRepository.saveAll(avioes);
    }


}
