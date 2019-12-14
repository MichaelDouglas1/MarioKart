package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;

public class JogadorParserDTO extends AbstractParser<JogadorDto, Jogador> {

	@Override
	public JogadorDto toDTO(Jogador entity) {

		JogadorDto dto = new JogadorDto();
		dto.setId(entity.getId());
		dto.setPersonagem(new PersonagemDto());

		dto.setNickname(entity.getNickname());

		dto.getPersonagem().setAceleracao(entity.getPersonagem().getAceleracao());
		dto.getPersonagem().setVelocidade(entity.getPersonagem().getVelocidade());
		dto.getPersonagem().setTurbo(entity.getPersonagem().getTurbo());
		dto.getPersonagem().setTracao(entity.getPersonagem().getTracao());
		dto.getPersonagem().setNome(entity.getPersonagem().getNome());
		dto.getPersonagem().setPeso(entity.getPersonagem().getPeso());
		dto.getPersonagem().setManobra(entity.getPersonagem().getManobra());
		dto.getPersonagem().setId(entity.getPersonagem().getId());
		return dto;
	}

	@Override
	public Jogador toEntity(JogadorDto dto) {
		Jogador entity = new Jogador();

		entity.setId(dto.getId());
		entity.setPersonagem(new Personagem());
		entity.setNickname(dto.getNickname());

		entity.getPersonagem().setAceleracao(dto.getPersonagem().getAceleracao());
		entity.getPersonagem().setVelocidade(dto.getPersonagem().getVelocidade());
		entity.getPersonagem().setTurbo(dto.getPersonagem().getTurbo());
		entity.getPersonagem().setTracao(dto.getPersonagem().getTracao());
		entity.getPersonagem().setNome(dto.getPersonagem().getNome());
		entity.getPersonagem().setPeso(dto.getPersonagem().getPeso());
		entity.getPersonagem().setManobra(dto.getPersonagem().getManobra());
		entity.getPersonagem().setId(dto.getPersonagem().getId());
		return entity;
	}

}
