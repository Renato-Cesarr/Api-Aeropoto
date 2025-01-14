package com.renato.aeroporto_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renato.aeroporto_api.logger.LoggerApi;
import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.service.AeroportoService;

@RestController
@RequestMapping("/aviao")
public class AeroportoController {

    @Autowired
    private AeroportoService aeroportoService;

    @PostMapping("/salvar-todos")
    public ResponseEntity<List<Aviao>> salvarTodosAvioes(@RequestBody List<Aviao> avioes) {
        LoggerApi.logRequest("Recebida solicitação para salvar todos os aviões.");
        
        if (avioes == null || avioes.isEmpty()) {
            LoggerApi.logRequestError("A lista de aviões está vazia ou nula.");
            return ResponseEntity.badRequest().build();
        }

        avioes.forEach(aviao -> {
            if (aviao.getModelo() == null || aviao.getFabricante() == null) {
                LoggerApi.logRequestError("Modelo ou fabricante ausentes em um dos aviões.");
            }
        });

        List<Aviao> avioesSalvos = aeroportoService.cadastrar(avioes);
        LoggerApi.logRequestDetails("Aviões salvos com sucesso: " + avioesSalvos);
        return ResponseEntity.ok(avioesSalvos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aviao> atualizar(@PathVariable Long id, @RequestBody Aviao aviao) {
        LoggerApi.logRequest("Recebida solicitação para atualizar o avião com ID: " + id);

        if (aviao == null) {
            LoggerApi.logRequestError("O corpo do avião está nulo.");
            return ResponseEntity.badRequest().build();
        }

        aviao.setNumeroDeSerie(id);
        Aviao aviaoAtualizado = aeroportoService.atualizar(aviao);
        LoggerApi.logRequestDetails("Avião atualizado com sucesso: " + aviaoAtualizado);
        return ResponseEntity.ok(aviaoAtualizado);
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Aviao>> buscarTodosAvioes() {
        LoggerApi.logRequest("Recebida solicitação para buscar todos os aviões.");
        List<Aviao> avioes = aeroportoService.listarTodos();
        LoggerApi.logRequestDetails("Aviões encontrados: " + avioes.size());
        return ResponseEntity.ok(avioes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aviao> buscarAviaoPorId(@PathVariable Long id) {
        LoggerApi.logRequest("Recebida solicitação para buscar o avião com ID: " + id);
        Aviao aviao = aeroportoService.listarPorId(id);

        if (aviao == null) {
            LoggerApi.logRequestError("Avião não encontrado com ID: " + id);
            return ResponseEntity.notFound().build();
        }

        LoggerApi.logRequestDetails("Avião encontrado: " + aviao);
        return ResponseEntity.ok(aviao);
    }

    @DeleteMapping("/apagar/{numeroDeSerie}")
    public ResponseEntity<Void> apagarAviao(@PathVariable Long numeroDeSerie) {
        LoggerApi.logRequest("Recebida solicitação para apagar o avião com número de série: " + numeroDeSerie);
        boolean apagado = aeroportoService.deletar(numeroDeSerie);

        if (!apagado) {
            LoggerApi.logRequestError("Avião não encontrado para exclusão com número de série: " + numeroDeSerie);
            return ResponseEntity.notFound().build();
        }

        LoggerApi.logRequestDetails("Avião com número de série " + numeroDeSerie + " foi apagado.");
        return ResponseEntity.noContent().build();
    }
}
