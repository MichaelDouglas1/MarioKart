package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class CorridaDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JogadorDto jogador;
	private String corridaLogs;
	
	
	private String jogadorVencedor;
	private String personagemVencedor;
	private String statusCorrida;
	
	
	public JogadorDto getJogador() {
		return jogador;
	}
	public void setJogador(JogadorDto jogador) {
		this.jogador = jogador;
	}
	public String getCorridaLogs() {
		return corridaLogs;
	}
	public void setCorridaLogs(String corridaLogs) {
		this.corridaLogs = corridaLogs;
	}
	public String getJogadorVencedor() {
		return jogadorVencedor;
	}
	public void setJogadorVencedor(String jogadorVencedor) {
		this.jogadorVencedor = jogadorVencedor;
	}
	public String getPersonagemVencedor() {
		return personagemVencedor;
	}
	public void setPersonagemVencedor(String personagemVencedor) {
		this.personagemVencedor = personagemVencedor;
	}
	public String getStatusCorrida() {
		return statusCorrida;
	}
	public void setStatusCorrida(String statusCorrida) {
		this.statusCorrida = statusCorrida;
	}


}