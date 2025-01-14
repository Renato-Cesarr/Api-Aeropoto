package com.renato.aeroporto_api.exception;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.renato.aeroporto_api.logger.LoggerApi;
import com.renato.aeroporto_api.model.Aviao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AviaoValidationService {
	
	public void validarNumeroDeSerie(Long numeroDeSerie) {
        if (numeroDeSerie == null || numeroDeSerie <= 0) {
            throw new InvalidNumeroDeSerieException("O número de série do avião é inválido.");
        }
    }
	
	public void validarListaAvioes(List<Aviao> avioes) {
        if (avioes == null || avioes.isEmpty()) {
            throw new InvalidAviaoListException("A lista de aviões não pode ser nula ou vazia.");
        }
    }
	
	public void validarFabricante(Aviao aviao) {
	    if (aviao.getFabricante() == null || aviao.getFabricante().isEmpty()) {
	        String erro = "O fabricante do avião é obrigatório.";
	        LoggerApi.logRequestError(erro);
	        throw new IllegalArgumentException(erro);
	    }
	}
	
	public void validarAviãoExistente(Aviao aviao, Optional<Aviao> aviaoExistente) {
	    if (!aviaoExistente.isPresent()) {
	        String erro = "Avião não encontrado com o número de série: " + aviao.getNumeroDeSerie();
	        LoggerApi.logRequestError(erro);
	        throw new EntityNotFoundException(erro);
	    }
	}
	
	public void validarId(Long id) {
	    if (id == null || id <= 0) {
	        String erro = "O ID do avião é inválido.";
	        LoggerApi.logRequestError(erro);
	        throw new InvalidIdException(erro);
	    }
	}
}
