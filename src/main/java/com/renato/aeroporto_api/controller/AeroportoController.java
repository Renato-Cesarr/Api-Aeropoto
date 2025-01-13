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

import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.service.AeroportoService;

@RestController
@RequestMapping("/aviao")
public class AeroportoController {

	@Autowired
	private AeroportoService aeroportoService;

	@PostMapping("/salvar-todos")
	public ResponseEntity<List<Aviao>> salvarTodosAvioes(@RequestBody List<Aviao> avioes) {
		List<Aviao> avioesSalvos = aeroportoService.salvarTodos(avioes);
		return ResponseEntity.ok(avioesSalvos);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Aviao> atualizar(@PathVariable Long id, @RequestBody Aviao aviao) {
	    aviao.setNumeroDeSerie(id);  // Definir o número de série no objeto Aviao recebido no corpo da requisição
	    Aviao aviaoAtualizado = aeroportoService.atualizar(aviao);
	    return ResponseEntity.ok(aviaoAtualizado);
	}




	@GetMapping("/todos")
	public ResponseEntity<List<Aviao>> buscarTodosAvioes() {
		List<Aviao> avioes = aeroportoService.buscarTodos();
		return ResponseEntity.ok(avioes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aviao> buscarAviaoPorId(@PathVariable Long id) {
		Aviao aviao = aeroportoService.buscarPorId(id);
		if (aviao == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(aviao);
	}

	@DeleteMapping("/apagar/{numeroDeSerie}")
	public ResponseEntity<Void> apagarAviao(@PathVariable Long numeroDeSerie) {
		boolean apagado = aeroportoService.apagarAviao(numeroDeSerie);
		if (!apagado) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
	
}
