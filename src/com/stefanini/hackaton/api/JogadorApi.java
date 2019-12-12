package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.dto.CadastroJogadorDto;
import com.stefanini.hackaton.dto.LoginJogadorDto;
import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.JogadorService;

@Path("/jogador")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class JogadorApi {
	
	@Inject
	private JogadorService jogadorService;
	
	@GET
	public Response listar() throws NegocioException {
		return Response.ok(jogadorService.listar()).build();
	}
	
	@POST
	public Response salvar(CadastroJogadorDto jogador) throws NegocioException {
		jogadorService.cadastrar(jogador);
		return Response.status(201).build();
	}
	
	@POST
	@Path("/logar")
	public Response logar(LoginJogadorDto jogador) throws NegocioException {
		return Response.ok(jogadorService.logar(jogador)).build();
	}	
	
	

}
