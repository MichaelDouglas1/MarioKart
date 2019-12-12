package com.stefanini.hackaton.service;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.CorridaDto;
import com.stefanini.hackaton.dto.PersonagemDto;

public class CorridaService {
	
	@Inject
	private JogadorService jogadorService;
	
	@Inject
	private PersonagemService personagemService;
	
	private CorridaDto corridaDto = new CorridaDto();
	
	private Integer laps = 0;
	
	private void corrida (PersonagemDto corredor) {
		
		Integer velocidadeMaxima = corredor.getVelocidade();
		
		
		
	
	}

}
