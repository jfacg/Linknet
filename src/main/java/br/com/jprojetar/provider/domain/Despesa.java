package br.com.jprojetar.provider.domain;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "despesa")
public class Despesa {

	@Id
	private String id;
	private TipoMovimento tipo;
	private String descricao;
	private Date dtVencimento;
	private Date dtPagamento;
	private double valor;
	private String status;
	private Fornecedor fornecedor;
	private String observacao;

	public Despesa() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoMovimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimento tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getVencimento() {
		return dtVencimento;
	}

	public void setVencimento(Date vencimento) {
		this.dtVencimento = vencimento;
	}

	public Date getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public Date getDtPagamento() {
		return dtPagamento;
	}

	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "Despesa [id=" + id + ", tipo=" + tipo + ", descricao=" + descricao + ", dtVencimento=" + dtVencimento
				+ ", dtPagamento=" + dtPagamento + ", valor=" + valor + ", fornecedor=" + fornecedor + ", observacao="
				+ observacao + "]";
	}



}
