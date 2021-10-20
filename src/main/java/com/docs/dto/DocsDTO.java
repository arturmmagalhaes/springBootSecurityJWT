package com.docs.dto;

import java.util.Date;

import com.docs.entities.Users;

public class DocsDTO {

	private String nome;	
	private String atributos;
	private String data;
	private String codigo;
	private String resumo;
	private Long idUsuario;
	
	public DocsDTO(String nome, String atributos, String data, String codigo, String resumo, Long idUsuario) {
		super();
		this.nome = nome;
		this.atributos = atributos;
		this.data = data;
		this.codigo = codigo;
		this.resumo = resumo;
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtributos() {
		return atributos;
	}

	public void setAtributos(String atributos) {
		this.atributos = atributos;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
}
