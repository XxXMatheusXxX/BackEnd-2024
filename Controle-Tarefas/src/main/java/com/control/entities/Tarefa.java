package com.control.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity

@Table(name = "Tarefa")

public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "nome")
	private String nome;
	

	@NotBlank(message = "Nome é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "dataFinal")
	private String dataFinal;
	
	@NotBlank(message = "Nome é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "descricaoTarefa")
	private String descricaoTarefa;
	
	@NotBlank(message = "Nome é obrigatório")
	@NotNull (message = "Não pode campo vazio")
	@Column(name = "statusTarefa")
	private String statusTarefa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}
	
	
	
}