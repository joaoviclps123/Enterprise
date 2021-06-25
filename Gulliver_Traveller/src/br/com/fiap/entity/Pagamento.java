package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.enun.ModPagamento;

@Entity
@Table(name = "TB_PAGAMENTO")
@SequenceGenerator(name = "pagamento", sequenceName = "SP_TB_PAGAMENTO", allocationSize = 1)
public class Pagamento {
	
	@Id
	@Column(name = "cd_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento")
	private int codigo;
	
	@Column(name = "md_pagamento", nullable = false)
	@Enumerated(EnumType.STRING)
	private ModPagamento modPag;
	
	@Column(name = "bd_bandeira", length = 50)
	private String bandeira;
	
	@Column(name = "em_email", length = 100)
	private String email;
	
	
	@Column(name = "vl_cartao")
	@Temporal(TemporalType.DATE)
	private Calendar validadeCartao;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_cliente", nullable = false)
	private Cliente cliente;

	
	public Pagamento() {
	}

	
	
	
	public Pagamento(ModPagamento modPag, String bandeira, String email, Calendar validadeCartao, Cliente cliente) {
		this.modPag = modPag;
		this.bandeira = bandeira;
		this.email = email;
		this.validadeCartao = validadeCartao;
		this.cliente = cliente;
	}




	public Pagamento(int codigo, ModPagamento modPag, String bandeira, String email, Calendar validadeCartao,
			Cliente cliente) {
		this.codigo = codigo;
		this.modPag = modPag;
		this.bandeira = bandeira;
		this.email = email;
		this.validadeCartao = validadeCartao;
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public ModPagamento getModPag() {
		return modPag;
	}

	public void setModPag(ModPagamento modPag) {
		this.modPag = modPag;
	}

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getComprovante() {
		return validadeCartao;
	}

	public void setComprovante(Calendar validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
