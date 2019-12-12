package com.stefanini.hackaton.parsers;

import com.stefanini.hackaton.dto.CadastroJogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.entities.Personagem;

public class CadastroJogadorParserDTO  extends AbstractParser<CadastroJogadorDto, Jogador> {

	@Override
	public CadastroJogadorDto toDTO(Jogador entity) {
		return null;
	}

	@Override
	public Jogador toEntity(CadastroJogadorDto dto) {
		Jogador entity = new Jogador();
		entity.setPersonagem(new Personagem());
		entity.setNickname(dto.getNickname());
		entity.setSenha(dto.getSenha());
		entity.getPersonagem().setId(dto.getIdPersonagem());
		return entity;
	}

	

}
