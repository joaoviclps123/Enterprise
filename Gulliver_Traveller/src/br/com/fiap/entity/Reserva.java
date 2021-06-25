package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.fiap.enun.Objetivo;
import br.com.fiap.enun.TipoPessoa;

@Entity
@Table(name = "TB_RESERVA")
@SequenceGenerator(name = "reserva", sequenceName = "SP_TB_RESERVA", allocationSize = 1)
public class Reserva {

	@Id
	@Column(name = "cd_reserva")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva")
	private int codigo;
	
	@Column(name = "pr_preco", nullable = false)
	private double preco;
	
	@Column(name = "dt_entrada", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dtEntrada;
	
	@Column(name = "dt_saida", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dtSaida;
	
	@Column(name = "nm_quartos", nullable = false)
	private int quartos;
	
	@Column(name = "tp_pessoa")
	@Enumerated(EnumType.STRING)
	private TipoPessoa tpPessoa;
	
	@Column(name = "ob_objetivo")
	@Enumerated(EnumType.STRING)
	private Objetivo objetivo;
	
	@Column(name = "nm_pessoas", nullable = false)
	private int pessoas;
	
	@ManyToOne
	@JoinColumn(name = "cd_hotel")
	private Hotel hotel;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_cliente")
	private Cliente cliente;

	public Reserva() {
	}
	
	
	
	public Reserva(double preco, Calendar dtEntrada, Calendar dtSaida, int quartos, TipoPessoa tpPessoa,
			Objetivo objetivo, int pessoas) {
		this.preco = preco;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.quartos = quartos;
		this.tpPessoa = tpPessoa;
		this.objetivo = objetivo;
		this.pessoas = pessoas;
	}



	public Reserva(double preco, Calendar dtEntrada, Calendar dtSaida, int quartos, TipoPessoa tpPessoa,
			Objetivo objetivo, int pessoas, Hotel hotel, Cliente cliente) {
		this.preco = preco;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.quartos = quartos;
		this.tpPessoa = tpPessoa;
		this.objetivo = objetivo;
		this.pessoas = pessoas;
		this.hotel = hotel;
		this.cliente = cliente;
	}

	public Reserva(int codigo, double preco, Calendar dtEntrada, Calendar dtSaida, int quartos, TipoPessoa tpPessoa,
			Objetivo objetivo, int pessoas, Hotel hotel, Cliente cliente) {
		this.codigo = codigo;
		this.preco = preco;
		this.dtEntrada = dtEntrada;
		this.dtSaida = dtSaida;
		this.quartos = quartos;
		this.tpPessoa = tpPessoa;
		this.objetivo = objetivo;
		this.pessoas = pessoas;
		this.hotel = hotel;
		this.cliente = cliente;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Calendar getDtEntrada() {
		return dtEntrada;
	}

	public void setDtEntrada(Calendar dtEntrada) {
		this.dtEntrada = dtEntrada;
	}

	public Calendar getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Calendar dtSaida) {
		this.dtSaida = dtSaida;
	}

	public int getQuartos() {
		return quartos;
	}

	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	public TipoPessoa getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(TipoPessoa tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public int getPessoas() {
		return pessoas;
	}

	public void setPessoas(int pessoas) {
		this.pessoas = pessoas;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
}










