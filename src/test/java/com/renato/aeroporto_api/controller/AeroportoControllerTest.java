package com.renato.aeroporto_api.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.renato.aeroporto_api.model.Aeroporto;
import com.renato.aeroporto_api.model.Aviao;
import com.renato.aeroporto_api.model.Carga;
import com.renato.aeroporto_api.model.Carga.StatusCarga;
import com.renato.aeroporto_api.model.FlyAware;
import com.renato.aeroporto_api.model.LicencaDePilotoAnac;
import com.renato.aeroporto_api.model.LicencaDePilotoAnac.SituacaoLicenca;
import com.renato.aeroporto_api.model.Localizacao;
import com.renato.aeroporto_api.model.Passageiro;
import com.renato.aeroporto_api.model.Piloto;
import com.renato.aeroporto_api.model.Piloto.StatusSaude;
import com.renato.aeroporto_api.model.TipoDeCarga;
import com.renato.aeroporto_api.model.TipoDeCarga.ClassificacaoPericulosidade;
import com.renato.aeroporto_api.model.Tripulacao;
import com.renato.aeroporto_api.repository.AeroportoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class ControllerAeroportoTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private AeroportoRepository aeroportoRepository;

	private List<Aviao> listaAavioes;

	@BeforeEach
	public void setUp() {
		LocalDateTime data = LocalDateTime.now();
		// Dados da Localização
		Localizacao dadosLocalizacao = new Localizacao();
		dadosLocalizacao.setCep("23456-789");
		dadosLocalizacao.setCidade("Rio de Janeiro");
		dadosLocalizacao.setEndereco("Avenida Santos Dumont, 2000");
		dadosLocalizacao.setEstado("RJ");

		// Licença De Piloto Anac
		LicencaDePilotoAnac licencaDePilotoAnac = new LicencaDePilotoAnac();
		licencaDePilotoAnac.setDataEmissao(data);
		licencaDePilotoAnac.setDataValidade(data);
		licencaDePilotoAnac.setSituacao(SituacaoLicenca.ATIVA);
		licencaDePilotoAnac.setTipoDaLicenca("Comercial");

		// Dados do Piloto
		Piloto piloto = new Piloto();
		piloto.setHorasDeVoo(4500);
		piloto.setLicencaDePilotoAnac(licencaDePilotoAnac);
		piloto.setNome("Carlos Pereira");
		piloto.setStatusDeSaude(StatusSaude.APTO);

		// Dados Tripulação
		Tripulacao tripulacao = new Tripulacao();
		tripulacao.setFuncao("Comissário");
		tripulacao.setHorasDeVoo(1800);
		tripulacao.setLicenciamento("Certificado");
		tripulacao.setNome("Equipe B");
		tripulacao.setNumeroVoo(2345);

		// Dados FlyAware
		FlyAware flyAware = new FlyAware();
		flyAware.setDestino("Rio de Janeiro");
		flyAware.setNumeroDaRota(456);
		flyAware.setOrigem("Miami");
		flyAware.setTempoEstimadoVoo(9.0);

		// Dados de Tipo de Carga
		TipoDeCarga tipoDeCarga = new TipoDeCarga();
		tipoDeCarga.setCargaFragil(false);
		tipoDeCarga.setCategoriaCarga("Perigosa");
		tipoDeCarga.setClassificacaoPericulosidade(ClassificacaoPericulosidade.ALTA);
		tipoDeCarga.setTemperaturaDaCarga(18.0);

		// Dados da Carga
		Carga carga = new Carga();
		carga.setPesoTotalCarga(75.0);
		carga.setStatusDaCarga(StatusCarga.PENDENTE);
		carga.setTipoDeCarga(tipoDeCarga);

		// Dados Passageiro(s)
		Passageiro passageiro = new Passageiro();
		passageiro.setAssento("14B");
		passageiro.setNome("Maria Costa");
		passageiro.setStatusEmbarque("EMBARCADO");
		List<Passageiro> listaPassageiros = new ArrayList<>();
		listaPassageiros.add(passageiro);

		// Dados do Avião
		Aviao aviao1 = new Aviao();
		aviao1.setCapacidadeMaximaKg(19000.0);
		aviao1.setCapacidadeMaximaPessoas(160);
		aviao1.setFabricante("Airbus");
		aviao1.setFlyAware(flyAware);
		aviao1.setModelo("A320");
		aviao1.setPassageiros(listaPassageiros);
		aviao1.setPiloto(piloto);
		aviao1.setTripulacao(tripulacao);

		listaAavioes = new ArrayList<>();
		listaAavioes.add(aviao1);

		// Dados Aeroporto
		List<Integer> numeroPortoesDeEmbarque = new ArrayList<>(Arrays.asList(9, 10, 11, 12, 13, 14));
		Aeroporto dadosAeroporto = new Aeroporto();
		dadosAeroporto.setAvioes(listaAavioes);
		dadosAeroporto.setCapacidadeDeArmazenamentoDeCombustivel(120.5);
		dadosAeroporto.setLimiteMaximoAeronaves(75);
		dadosAeroporto.setLocalizacao(dadosLocalizacao);
		dadosAeroporto.setNome("Aeroporto Internacional do Rio de Janeiro");
		dadosAeroporto.setPermitidoPousoAeronaves(true);
		dadosAeroporto.setPortoesDeEmbarque(numeroPortoesDeEmbarque);
		dadosAeroporto.setCodigoIATA(3L);
	    aviao1.setAeroporto(dadosAeroporto);
	}

	@Test
	void testCadastrarAeroporto() {
		ResponseEntity<String> response = restTemplate.exchange("/aviao/salvar-todos", HttpMethod.POST,
				new HttpEntity<>(listaAavioes), String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
		Assert.assertNotNull(response.getBody());
	}

	@Test
	void testUpdateAeroporto() {
	    Long numeroSerie = 4L;
	    Aviao aviaoParaAtualizar = listaAavioes.get(0);  // Pega o primeiro avião da lista para enviar
	    ResponseEntity<Aviao> response = restTemplate.exchange("/aviao/atualizar/" + numeroSerie,
	            HttpMethod.PUT, new HttpEntity<>(aviaoParaAtualizar), Aviao.class);
	    Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testUpdateAeroportoNaoEncontrado() {
		Long numeroSerieInvalido = 999L;
		Aviao aviaoParaTentativaAtualizacao = listaAavioes.get(0);
		ResponseEntity<Aviao> response = restTemplate.exchange("/aviao/atualizar/" + numeroSerieInvalido,
				HttpMethod.PUT, new HttpEntity<>(aviaoParaTentativaAtualizacao), Aviao.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testGetAeroportoInfo() {
		ResponseEntity<String> response = restTemplate.exchange("/aviao/todos", HttpMethod.GET, null, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void testBuscarAviaoPorId() {
		ResponseEntity<String> response = restTemplate.exchange("/aviao/2", HttpMethod.GET, null, String.class);
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}
	
	@Test
	void testApagarAviao() {
		restTemplate.delete("/apagar/"+1L);
		ResponseEntity<Aviao> response = restTemplate.getForEntity("/apagar/"+1L, Aviao.class);
		Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

}
