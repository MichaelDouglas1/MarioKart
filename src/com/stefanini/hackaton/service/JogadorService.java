package com.stefanini.hackaton.service;

import java.util.Base64;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import com.stefanini.hackaton.dto.CadastroJogadorDto;
import com.stefanini.hackaton.dto.JogadorDto;
import com.stefanini.hackaton.dto.LoginJogadorDto;
import com.stefanini.hackaton.entities.Jogador;
import com.stefanini.hackaton.parsers.CadastroJogadorParserDTO;
import com.stefanini.hackaton.parsers.JogadorParserDTO;
import com.stefanini.hackaton.parsers.PersonagemParserDTO;
import com.stefanini.hackaton.persistence.JogadorDAO;
import com.stefanini.hackaton.rest.exceptions.NegocioException;

@Transactional
public class JogadorService {
	
	@Inject
	JogadorParserDTO jogadorParser;
	
	@Inject
	PersonagemParserDTO personagemParser;
	
	@Inject
	PersonagemService personagemService;
	
	@Inject
	JogadorDAO jogadorDao;	
	
	@Inject
	CadastroJogadorParserDTO cadastroJogadorParser;
	

	public List<JogadorDto> listar() throws NegocioException{
		List<JogadorDto> LJogadores = jogadorParser.toDTO(jogadorDao.list());
		if (LJogadores.size() > 0) {
			return LJogadores;
		}
		
		throw new NegocioException("Não há jogadores cadastrados");
		//return jogadorParser.toDTO(jogadorDao.list());
	}
	
	
	public List<JogadorDto> cadastrar(CadastroJogadorDto cadastro) throws NegocioException{


		if (cadastro.getNickname() == null || cadastro.getNickname().equals("") || cadastro.getNickname().length() <= 0 || cadastro.getSenha() == null) {
			throw new NegocioException("Dados incorretos!");
		}
		
		if (cadastro.getNickname().contains(" ")) {
			throw new NegocioException("Nickname não pode conter espaços em branco");
		}
		
		
		String checarSenha = new String(Base64.getDecoder().decode(cadastro.getSenha().getBytes()));
		
		if (checarSenha.length() < 6 || checarSenha.length() > 8) {
			throw new NegocioException("A senha deve possuir o tamanho entre 6 ou 8 caracteres!");
		}

		System.out.println("Criptografada: " + cadastro.getSenha() + " -> " + checarSenha);
		
		//if (cadastro.getSenha().length() < 6 || cadastro.getSenha().length() > 8) {
		//throw new NegocioException("A senha deve possuir o tamanho entre 6 ou 8 caracteres!");
			
		//}
		
		if (cadastro.getIdPersonagem() == null) {
			throw new NegocioException("Personagem não selecionado!");
		}
		
		for (Jogador jogador : jogadorDao.list()) {
			if(jogador.getNickname().equals(cadastro.getNickname())){
				throw new NegocioException("Um usuario com esse Nickname ja existe!");
			}
		}
		
		Jogador jogador = cadastroJogadorParser.toEntity(cadastro);
		jogador.setPersonagem(personagemParser.toEntity(personagemService.obter(jogador.getPersonagem().getId())));
		
		jogadorDao.insert(jogador);
		
		return jogadorParser.toDTO(jogadorDao.list());		
	}
	
	
	public JogadorDto logar(LoginJogadorDto logado) throws NegocioException{
		
		for(Jogador jogador : jogadorDao.list()) {
			if(logado.getNickname().equals(jogador.getNickname())) {
				if(logado.getSenha().equals(jogador.getSenha())) {
					return jogadorParser.toDTO(jogador);	
				}
			
			}
		}
		
		throw new NegocioException("Ops! Seu nickname ou senha estão incorretos!");
	}
	

}








