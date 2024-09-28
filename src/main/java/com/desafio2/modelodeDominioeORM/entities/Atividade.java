package com.desafio2.modelodeDominioeORM.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	private double preco;

	@ManyToMany
	@JoinTable(name = "tb_atividade_participante", joinColumns = @JoinColumn(name = "atividade_id"), inverseJoinColumns = @JoinColumn(name = "participante_id"))
	private List<Participante> participantes = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "atividade")
	private List<Bloco> blocos = new ArrayList<>();
	
	public Atividade() {

	}

	public Atividade(int id, String nome, String descricao, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
