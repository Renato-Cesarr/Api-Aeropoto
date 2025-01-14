package com.renato.aeroporto_api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.converter.HttpMessageNotReadableException;

import com.renato.aeroporto_api.exception.dto.ApiResponse;
import com.renato.aeroporto_api.logger.LoggerApi;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AviaoNotFoundException.class)
	public ResponseEntity<ApiResponse> tratarErroAviaoNaoEncontrado(AviaoNotFoundException ex) {
		ApiResponse apiResponse = new ApiResponse(ex.getMessage(), "Avião não encontrado com o ID fornecido.",
				LocalDateTime.now());

		LoggerApi.logRequestError("Avião não encontrado: " + ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiResponse> handleJsonParseError(HttpMessageNotReadableException ex) {
		ApiResponse apiResponse = new ApiResponse("Erro ao processar a requisição: " + ex.getMessage(),
				"Verifique se os tipos dos dados no JSON estão corretos.", LocalDateTime.now());

		LoggerApi.logRequestError("Erro ao processar JSON: " + ex.getMessage());

		return ResponseEntity.badRequest().body(apiResponse);
	}
}
