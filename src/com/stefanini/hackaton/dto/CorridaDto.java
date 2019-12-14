package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class CorridaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tipo;
	private Long comprimentoMetro;

	public CorridaDto(String tipo, Long comprimentoMetro) {

		this.tipo = tipo;
		this.comprimentoMetro = comprimentoMetro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getComprimentoMetro() {
		return comprimentoMetro;
	}

	public void setComprimentoMetro(Long comprimentoMetro) {
		this.comprimentoMetro = comprimentoMetro;
	}

}