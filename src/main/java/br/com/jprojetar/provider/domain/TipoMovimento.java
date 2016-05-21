package br.com.jprojetar.provider.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "tipoMovimento")
public class TipoMovimento {

	@Id
	private String nome;
	private String descricao;

	public TipoMovimento() {

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

	@Override
	public String toString() {
		return "TipoMovimento [nome=" + nome + ", descricao=" + descricao + "]";
	}

}
