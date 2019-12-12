package com.stefanini.hackaton.service;

import java.util.List;

import javax.inject.Inject;

import com.stefanini.hackaton.dto.PersonagemDto;
import com.stefanini.hackaton.parsers.PersonagemParserDTO;
import com.stefanini.hackaton.persistence.PersonagemDAO;

public class PersonagemService {

	@Inject
	PersonagemParserDTO parser;
	
	@Inject
	PersonagemDAO personagemDao;


	public List<PersonagemDto> listar() {
		return parser.toDTO(personagemDao.list());
	}
	
	 public PersonagemDto obter(Integer id) {
	        return parser.toDTO(personagemDao.findById(id));
	    }

}
