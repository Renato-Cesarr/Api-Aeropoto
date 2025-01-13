package com.renato.aeroporto_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.repository.AviaoRepository;

import jakarta.persistence.EntityNotFoundException;

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
    
    public boolean apagarAviao(Long numeroDeSerie) {
        Optional<Aviao> aviaoExistente = aviaoRepository.findById(numeroDeSerie);
        if (aviaoExistente.isPresent()) {
            aviaoRepository.delete(aviaoExistente.get());
            return true;
        } 
        return false; 
    }

    public Aviao atualizar(Aviao aviao) {
        if (aviao.getNumeroDeSerie() == null) {
            throw new IllegalArgumentException("O ID do avião não pode ser nulo.");
        }

        Optional<Aviao> aviaoExistente = aviaoRepository.findById(aviao.getNumeroDeSerie());
        if (!aviaoExistente.isPresent()) {
            throw new EntityNotFoundException("Avião não encontrado com o número de série: " + aviao.getNumeroDeSerie());
        }

        // Se o avião existe, fazemos o update
        return aviaoRepository.save(aviao);
    }





}
