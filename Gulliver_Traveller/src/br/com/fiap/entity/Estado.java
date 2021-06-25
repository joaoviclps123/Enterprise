package br.com.fiap.entity;

import java.util.List;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.enun.Zona;

@Entity
@Table(name = "TB_ESTADO")
@SequenceGenerator(name = "estado", sequenceName = "SP_TB_ESTADO", allocationSize = 1)
public class Estado {
	
	@Id
	@Column(name = "cd_estado")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estado")
	private int codigo;
	
	@Column(name = "nm_nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "nm_acomodacoes")
	private int acomodacoes;
	
	@Column(name = "zn_zona", length = 20) 
	@Enumerated(EnumType.STRING)
	private Zona zona;
	
	@Column(name = "pa_pais", length = 30, nullable = false)
	private String pais;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "TB_ESTADO_HOTEL", joinColumns = @JoinColumn(name = "cd_estado"),
	inverseJoinColumns = @JoinColumn(name = "cd_hoteis"))
	private List<Hotel> hoteis;

	
	public Estado() {
	}
	
	
	
	public Estado(String nome) {
		this.nome = nome;
	}

	

	public Estado(String nome, int acomodacoes, Zona zona, String pais) {
		this.nome = nome;
		this.acomodacoes = acomodacoes;
		this.zona = zona;
		this.pais = pais;
	}



	public Estado(String nome, int acomodacoes, Zona zona, String pais, List<Hotel> hoteis) {
		this.nome = nome;
		this.acomodacoes = acomodacoes;
		this.zona = zona;
		this.pais = pais;
		this.hoteis = hoteis;
	}

	public Estado(int codigo, String nome, int acomodacoes, Zona zona, String pais, List<Hotel> hoteis) {
		this.codigo = codigo;
		this.nome = nome;
		this.acomodacoes = acomodacoes;
		this.zona = zona;
		this.pais = pais;
		this.hoteis = hoteis;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAcomodacoes() {
		return acomodacoes;
	}

	public void setAcomodacoes(int acomodacoes) {
		this.acomodacoes = acomodacoes;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Hotel> getHoteis() {
		return hoteis;
	}

	public void setHoteis(List<Hotel> hoteis) {
		this.hoteis = hoteis;
	}
	
	
}
