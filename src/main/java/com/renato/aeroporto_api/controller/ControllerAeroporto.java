package com.renato.aeroporto_api.controller;

import com.renato.aeroporto_api.model.Aeroporto;
import com.renato.aeroporto_api.service.ServiceAeroporto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Aeroporto> getAeroportoInfo() {
        return aeroportoService.getAeroportoInfo();
    }

    @PatchMapping("/{index}")
    public String updateAeroporto(@PathVariable("index") int index,
                                  @RequestBody Aeroporto aeroporto) {
        return aeroportoService.updateAeroporto(index, aeroporto);
    }

    @DeleteMapping("/{index}")
    public String deleteAeroporto(@PathVariable("index") int index) {
        return aeroportoService.deleteAeroporto(index);
    }
}
