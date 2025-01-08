package com.renato.aeroporto_api.controller;

import com.renato.aeroporto_api.model.Aeroporto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aeroporto")
public class ControllerAeroporto {
	

	private List<Aeroporto> aeroportos = new ArrayList<>();

	@PostMapping
	public Aeroporto createAeroporto(@RequestBody Aeroporto aeroporto) {
		aeroportos.add(aeroporto);
		return aeroporto;
	}

	@GetMapping
	public List<Aeroporto> getAeroportoInfo() {
		return aeroportos;
	}

    @PutMapping("/{nomeAeroporto}")
    public String updateAeroporto(@PathVariable("nomeAeroporto") String nomeAeroporto,
                                  @RequestBody Aeroporto aeroporto) {
        for (Aeroporto aero : aeroportos) {
            if (aero.getNomeAeroporto().equals(nomeAeroporto)) {
                aero.setNomeAeroporto(aeroporto.getNomeAeroporto());
                return "Aeroporto atualizado com sucesso!";
            }
        }
        throw new RuntimeException("Aeroporto não encontrado.");
    }

}
