package com.renato.aeroporto_api.service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.renato.aeroporto_api.exception.AeroportoNotFoundException;
import com.renato.aeroporto_api.exception.AviaoNotFoundException;
import com.renato.aeroporto_api.model.Aeroporto;
import com.renato.aeroporto_api.model.Aviao;

@Service
public class ServiceAeroporto {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAeroporto.class);

    private Map<String, Aeroporto> aeroportos = new HashMap<>();

    public Aeroporto createAeroporto(Aeroporto aeroporto) {
        aeroportos.put(aeroporto.getNomeAeroporto(), aeroporto);
        logger.info("Aeroporto criado: {}", aeroporto.getNomeAeroporto());
        return aeroporto;
    }

    public Map<String, Aeroporto> getAeroportoInfo() {
        logger.info("Informações dos aeroportos requisitadas");
        return aeroportos;
    }

    public String updateAeroporto(String nomeAeroporto, Aeroporto aeroporto) {
        if (aeroportos.containsKey(nomeAeroporto)) {
            Aeroporto aero = aeroportos.get(nomeAeroporto);
            aero.setNomeAeroporto(aeroporto.getNomeAeroporto());
            logger.info("Aeroporto atualizado: {}", nomeAeroporto);
            return "Aeroporto atualizado com sucesso!";
        }
        logger.warn("Aeroporto não encontrado com nome: {}", nomeAeroporto);
        throw new AeroportoNotFoundException("Aeroporto não encontrado: " + nomeAeroporto);
    }

    public Aeroporto replaceAeroporto(String nomeAeroporto, Aeroporto novoAeroporto) {
        if (aeroportos.containsKey(nomeAeroporto)) {
            aeroportos.put(nomeAeroporto, novoAeroporto);
            logger.info("Aeroporto substituído: {}", nomeAeroporto);
            return novoAeroporto;
        }
        logger.warn("Aeroporto não encontrado para substituição: {}", nomeAeroporto);
        throw new AeroportoNotFoundException("Aeroporto não encontrado: " + nomeAeroporto);
    }

    public String updateAviao(Integer numeroDeSerie, Aviao aviaoAtualizado) {
        for (Aeroporto aeroporto : aeroportos.values()) {
            Aviao aviao = (Aviao) aeroporto.getAviao();
            if (aviao != null && aviao.getNumeroDeSerie().equals(numeroDeSerie)) {
                updateCamposSimples(aviao, aviaoAtualizado);
                logger.info("Avião atualizado com sucesso! Número de série: {}", numeroDeSerie);
                return "Avião atualizado com sucesso!";
            }
        }
        logger.warn("Avião não encontrado com número de série: {}", numeroDeSerie);
        throw new AviaoNotFoundException("Avião com o número de série informado não encontrado: " + numeroDeSerie);
    }

    private void updateCamposSimples(Aviao aviao, Aviao aviaoAtualizado) {
        Map<String, Consumer<Aviao>> fieldUpdaters = new HashMap<>();

        fieldUpdaters.put("modelo", a -> a.setModelo(aviaoAtualizado.getModelo()));
        fieldUpdaters.put("fabricante", a -> a.setFabricante(aviaoAtualizado.getFabricante()));
        fieldUpdaters.put("capacidadeMaximaKg", a -> a.setCapacidadeMaximaKg(aviaoAtualizado.getCapacidadeMaximaKg()));
        fieldUpdaters.put("capacidadeMaximaPessoas", a -> a.setCapacidadeMaximaPessoas(aviaoAtualizado.getCapacidadeMaximaPessoas()));

        fieldUpdaters.forEach((field, updater) -> updater.accept(aviao));
    }

    public String deleteAeroporto(String nomeAeroporto) {
        if (aeroportos.containsKey(nomeAeroporto)) {
            aeroportos.remove(nomeAeroporto);
            logger.info("Aeroporto removido: {}", nomeAeroporto);
            return "Aeroporto removido com sucesso!";
        }
        logger.warn("Aeroporto não encontrado para remoção: {}", nomeAeroporto);
        throw new AeroportoNotFoundException("Aeroporto não encontrado: " + nomeAeroporto);
    }
}
