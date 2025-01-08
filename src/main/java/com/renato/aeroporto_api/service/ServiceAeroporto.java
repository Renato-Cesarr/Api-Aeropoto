package com.renato.aeroporto_api.service;

import com.renato.aeroporto_api.model.Aeroporto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceAeroporto {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAeroporto.class);

    private List<Aeroporto> aeroportos = new ArrayList<>();

    public Aeroporto createAeroporto(Aeroporto aeroporto) {
        aeroportos.add(aeroporto);
        logger.info("Aeroporto criado: " + aeroporto.getNomeAeroporto());
        return aeroporto;
    }

    public List<Aeroporto> getAeroportoInfo() {
        logger.info("Informações dos aeroportos requisitadas");
        return aeroportos;
    }

    public String updateAeroporto(int index, Aeroporto aeroporto) {
        if (index >= 0 && index < aeroportos.size()) {
            Aeroporto aero = aeroportos.get(index);
            aero.setNomeAeroporto(aeroporto.getNomeAeroporto());
            logger.info("Aeroporto atualizado no índice {}: {}", index, aeroporto.getNomeAeroporto());
            return "Aeroporto atualizado com sucesso!";
        }
        logger.warn("Tentativa de atualização com índice inválido: {}", index);
        throw new RuntimeException("Índice inválido.");
    }

    public String deleteAeroporto(int index) {
        if (index >= 0 && index < aeroportos.size()) {
            Aeroporto aero = aeroportos.get(index);
            aero.setNomeAeroporto(null);
            logger.info("Aeroporto removido no índice {}: {}", index, aero.getNomeAeroporto());
            return "Aeroporto removido com sucesso!";
        }
        logger.warn("Tentativa de remoção com índice inválido: {}", index);
        throw new RuntimeException("Índice inválido.");
    }
}
