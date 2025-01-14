package com.renato.aeroporto_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renato.aeroporto_api.exception.AviaoNotFoundException;
import com.renato.aeroporto_api.exception.AviaoValidationService;
import com.renato.aeroporto_api.exception.InvalidAviaoListException;
import com.renato.aeroporto_api.exception.InvalidNumeroDeSerieException;
import com.renato.aeroporto_api.logger.LoggerApi;
import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.repository.AviaoRepository;


@Service
public class AeroportoService {

    @Autowired
    private AviaoRepository aviaoRepository;
    
    @Autowired
    private AviaoValidationService aviaoValidationService;

    public List<Aviao> buscarTodos() {
        LoggerApi.logRequest("Buscando todos os aviões no banco de dados.");
        return aviaoRepository.findAll();
    }

    public Aviao buscarPorId(Long id) {
    	aviaoValidationService.validarId(id);
    	
        LoggerApi.logRequest("Buscando avião com ID: " + id);
        return aviaoRepository.findById(id)
            .orElseThrow(() -> new AviaoNotFoundException("Avião não encontrado com o ID: " + id));
    }

    public List<Aviao> salvarTodos(List<Aviao> avioes) {
        try {
            aviaoValidationService.validarListaAvioes(avioes);

            LoggerApi.logRequest("Lista de aviões sendo salva no banco de dados.");
            return aviaoRepository.saveAll(avioes);

        } catch (InvalidAviaoListException ex) {
            LoggerApi.logRequestError(ex.getMessage());
            throw ex;
        }
    }

    public boolean apagarAviao(Long numeroDeSerie) {
        try {
            aviaoValidationService.validarNumeroDeSerie(numeroDeSerie);

            LoggerApi.logRequest("Procurando avião para exclusão com número de série: " + numeroDeSerie);
            Optional<Aviao> aviaoExistente = aviaoRepository.findById(numeroDeSerie);

            if (aviaoExistente.isPresent()) {
                aviaoRepository.delete(aviaoExistente.get()); // nao pude usar a validação de existencia por conta do tipo de dado do metodo.
                LoggerApi.logRequestDetails("Avião excluído com sucesso.");
                return true;
            }
            LoggerApi.logRequestError("Avião não encontrado para exclusão com número de série: " + numeroDeSerie);
            throw new AviaoNotFoundException("Avião não encontrado para exclusão com número de série: " + numeroDeSerie);
        } catch (InvalidNumeroDeSerieException | AviaoNotFoundException ex) {
            LoggerApi.logRequestError(ex.getMessage());
            throw ex;
        }
    }

    public Aviao atualizar(Aviao aviao) {
        aviaoValidationService.validarNumeroDeSerie(aviao.getNumeroDeSerie());
        aviaoValidationService.validarFabricante(aviao);

        LoggerApi.logRequest("Atualizando avião com ID: " + aviao.getNumeroDeSerie());
        Optional<Aviao> aviaoExistente = aviaoRepository.findById(aviao.getNumeroDeSerie());

        aviaoValidationService.validarAviãoExistente(aviao, aviaoExistente);
        Aviao aviaoAtualizado = aviaoRepository.save(aviao);
        LoggerApi.logRequestDetails("Avião atualizado com sucesso: " + aviaoAtualizado);
        return aviaoAtualizado;
    }
}
