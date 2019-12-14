package com.stefanini.hackaton.dto;

import java.io.Serializable;

public class CadastroJogadorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nickname;
	private String senha;
	private Integer IdPersonagem;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getIdPersonagem() {
		return IdPersonagem;
	}

	public void setIdPersonagem(Integer idPersonagem) {
		IdPersonagem = idPersonagem;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
