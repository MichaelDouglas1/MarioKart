package com.stefanini.hackaton.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.stefanini.hackaton.rest.exceptions.NegocioException;
import com.stefanini.hackaton.service.CorridaService;

@Path("/correr")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CorridaApi {
	
	@Inject
	private CorridaService corridaService;
	
	@GET
	public Response iniciar() throws NegocioException {
		return Response.ok(corridaService.iniciarCorrida()).build();
	}
	

}
