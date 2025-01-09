package com.renato.aeroporto_api.controller;

import com.renato.aeroporto_api.model.Aeroporto;
import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.service.ServiceAeroporto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/aeroporto")
public class ControllerAeroporto {

    @Autowired
    private ServiceAeroporto aeroportoService;

    @PostMapping
    public Aeroporto createAeroporto(@RequestBody Aeroporto aeroporto) {
        return aeroportoService.createAeroporto(aeroporto);
    }

    @GetMapping
    public Map<String, Aeroporto> getAeroportoInfo() {
        return aeroportoService.getAeroportoInfo();
    }

    @PatchMapping("/{nomeAeroporto}")
    public String updateAeroporto(@PathVariable("nomeAeroporto") String nomeAeroporto,
                                  @RequestBody Aeroporto aeroporto) {
        return aeroportoService.updateAeroporto(nomeAeroporto, aeroporto);
    }

    @DeleteMapping("/{nomeAeroporto}")
    public String deleteAeroporto(@PathVariable("nomeAeroporto") String nomeAeroporto) {
        return aeroportoService.deleteAeroporto(nomeAeroporto);
    }

    @PutMapping("/aviao/{numeroDeSerie}")
    public String updateAviao(@PathVariable("numeroDeSerie") Integer numeroDeSerie,
                              @RequestBody Aviao aviaoAtualizado) {
        return aeroportoService.updateAviao(numeroDeSerie, aviaoAtualizado);
    }
    
    @PutMapping("/{nomeAeroporto}")
    public Aeroporto replaceAeroporto(@PathVariable("nomeAeroporto") String nomeAeroporto,
                                      @RequestBody Aeroporto novoAeroporto) {
        return aeroportoService.replaceAeroporto(nomeAeroporto, novoAeroporto);
    }

}
