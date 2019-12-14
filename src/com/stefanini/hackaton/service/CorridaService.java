package com.stefanini.hackaton.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.math.NumberUtils;

import com.stefanini.hackaton.dto.CorridaDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.dto.ResultadoDto;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;

public class CorridaService {

	@Inject
	private PersonagemService personagemService;

	@Inject
	JogadorParserDTO jogadorParser;

	@Inject
	JogadorDAO jogadorDao;

	static final Integer NRO_TWO = 2;
	static final Integer NRO_TREE = 3;
	static final Double NRO_ZERO_ONE = 0.01d;

	// PersonagemDto personagem = iniciarCorrida(personagens, configuracaoPista);

	public ResultadoDto iniciarCorrida() {
		List<PersonagemDto> personagens = personagemService.listar();
		List<CorridaDto> configuracaoPista = fabricaPista(NumberUtils.INTEGER_ONE);

		Double melhorPontuacao = Double.MAX_VALUE;
		PersonagemDto personagem = null;
		Double maiorVelocidadeAuxPorVolta = NumberUtils.DOUBLE_ZERO;

		for (PersonagemDto personagemSelecionado : personagens) {
			Double pontuacaoPorPercuso = NumberUtils.DOUBLE_ZERO;

			Double velocidadeMaximaCarro = obterVelocidadeMaximaCarro(personagemSelecionado).doubleValue();

			for (CorridaDto percurso : configuracaoPista) {

				if (percurso.getTipo().equals("reta")) {
					pontuacaoPorPercuso = percurso.getComprimentoMetro().doubleValue() / velocidadeMaximaCarro;
				}
				if (percurso.getTipo().equals("curva")) {
					pontuacaoPorPercuso = (percurso.getComprimentoMetro().doubleValue() / velocidadeMaximaCarro)
							/ NRO_TWO;
				}
				maiorVelocidadeAuxPorVolta = Double.sum(maiorVelocidadeAuxPorVolta,
						aplicarRegraConfiguracaoCarro(personagemSelecionado, pontuacaoPorPercuso));
				pontuacaoPorPercuso = NumberUtils.DOUBLE_ZERO;
			}
			if (maiorVelocidadeAuxPorVolta < melhorPontuacao) {
				melhorPontuacao = maiorVelocidadeAuxPorVolta;
				personagem = personagemSelecionado;
			}

		}

		String resultado = "O personagem " + personagem.getNome() + " teve o menor tempo na corrida!";

		ResultadoDto resultadoDto = new ResultadoDto();

		resultadoDto.setIdVencedor(personagem.getId());
		resultadoDto.setMensagemResultado(resultado);

		return resultadoDto;
	}

	private static Double aplicarRegraConfiguracaoCarro(PersonagemDto personagemSelecionado,
			Double maiorVelocidadeAux) {
		maiorVelocidadeAux = regraPeso(personagemSelecionado, maiorVelocidadeAux);
		maiorVelocidadeAux = regraAceleracao(personagemSelecionado, maiorVelocidadeAux);
		maiorVelocidadeAux = regraTurbo(personagemSelecionado, maiorVelocidadeAux);
		maiorVelocidadeAux = regraTracaoManobra(personagemSelecionado, maiorVelocidadeAux);
		return maiorVelocidadeAux;
	}

	private static Double regraPeso(PersonagemDto personagemSelecionado, Double maiorVelocidadeAux) {
		return maiorVelocidadeAux + (NRO_ZERO_ONE * personagemSelecionado.getPeso().doubleValue());
	}

	private static Double regraAceleracao(PersonagemDto personagemSelecionado, Double maiorVelocidadeAux) {
		return maiorVelocidadeAux * (NRO_ZERO_ONE * personagemSelecionado.getAceleracao().doubleValue());
	}

	private static Double regraTurbo(PersonagemDto personagemSelecionado, Double maiorVelocidadeAux) {
		return maiorVelocidadeAux * (NRO_ZERO_ONE * personagemSelecionado.getTurbo().doubleValue());
	}

	private static Double regraTracaoManobra(PersonagemDto personagemSelecionado, Double maiorVelocidadeAux) {
		if (personagemSelecionado.getTracao() > personagemSelecionado.getPeso()
				&& personagemSelecionado.getManobra() > personagemSelecionado.getPeso()) {
			return maiorVelocidadeAux / NRO_TWO;
		}

		if (personagemSelecionado.getTracao() < personagemSelecionado.getPeso()
				&& personagemSelecionado.getManobra() < personagemSelecionado.getPeso()) {
			return (maiorVelocidadeAux / NRO_TREE) * NRO_TWO;
		}
		return maiorVelocidadeAux;
	}

	private static Integer obterVelocidadeMaximaCarro(PersonagemDto personagemSelecionado) {
		Integer velocidadeMaximaAlcancadaPorCarro = personagemSelecionado.getVelocidade();
		return velocidadeMaximaAlcancadaPorCarro;
	}

	private static List<CorridaDto> fabricaPista(Integer pistaSelecionada) {
		List<CorridaDto> configuracaoPista = new ArrayList<>();
		switch (pistaSelecionada) {
		case 1:
			configuracaoPista = Arrays.asList(new CorridaDto("reta", 490l), new CorridaDto("curva", 1l),
					new CorridaDto("reta", 10l), new CorridaDto("curva", 1l), new CorridaDto("reta", 490l),
					new CorridaDto("curva", 1l), new CorridaDto("reta", 10l), new CorridaDto("curva", 1l));
			break;
		}
		return configuracaoPista;
	}

}