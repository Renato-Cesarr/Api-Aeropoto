package com.renato.aeroporto_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.aeroporto_api.logger.LoggerApi;
import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.repository.AviaoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AeroportoService {

    @Autowired
    private AviaoRepository aviaoRepository;

    public List<Aviao> buscarTodos() {
        LoggerApi.logRequest("Buscando todos os aviões no banco de dados.");
        return aviaoRepository.findAll();
    }

    public Aviao buscarPorId(Long id) {
        LoggerApi.logRequest("Buscando avião com ID: " + id);
        return aviaoRepository.findById(id).orElse(null);
    }

    public List<Aviao> salvarTodos(List<Aviao> avioes) {
        LoggerApi.logRequest("Salvando lista de aviões no banco de dados.");
        return aviaoRepository.saveAll(avioes);
    }

    public boolean apagarAviao(Long numeroDeSerie) {
        LoggerApi.logRequest("Procurando avião para exclusão com número de série: " + numeroDeSerie);
        Optional<Aviao> aviaoExistente = aviaoRepository.findById(numeroDeSerie);

        if (aviaoExistente.isPresent()) {
            aviaoRepository.delete(aviaoExistente.get());
            LoggerApi.logRequestDetails("Avião excluído com sucesso.");
            return true;
        }

        LoggerApi.logRequestError("Avião não encontrado para exclusão com número de série: " + numeroDeSerie);
        return false;
    }

    public Aviao atualizar(Aviao aviao) {
        if (aviao.getNumeroDeSerie() == null) {
            String errorMsg = "O ID do avião não pode ser nulo.";
            LoggerApi.logRequestError(errorMsg);
            throw new IllegalArgumentException(errorMsg);
        }

        LoggerApi.logRequest("Atualizando avião com ID: " + aviao.getNumeroDeSerie());
        Optional<Aviao> aviaoExistente = aviaoRepository.findById(aviao.getNumeroDeSerie());

        if (!aviaoExistente.isPresent()) {
            String errorMsg = "Avião não encontrado com o número de série: " + aviao.getNumeroDeSerie();
            LoggerApi.logRequestError(errorMsg);
            throw new EntityNotFoundException(errorMsg);
        }

        Aviao aviaoAtualizado = aviaoRepository.save(aviao);
        LoggerApi.logRequestDetails("Avião atualizado com sucesso: " + aviaoAtualizado);
        return aviaoAtualizado;
    }
}
