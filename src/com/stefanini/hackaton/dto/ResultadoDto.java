package com.stefanini.hackaton.dto;

import java.io.Serializable;

import com.stefanini.hackaton.entities.Personagem;

public class ResultadoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idVencedor;
	
	private String mensagemResultado;

	
	public Integer getIdVencedor() {
		return idVencedor;
	}

	public void setIdVencedor(Integer idVencedor) {
		this.idVencedor = idVencedor;
	}

	public String getMensagemResultado() {
		return mensagemResultado;
	}

	public void setMensagemResultado(String mensagemResultado) {
		this.mensagemResultado = mensagemResultado;
	}
	
	

}
