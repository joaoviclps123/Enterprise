package br.com.fiap.entity;

import java.util.ArrayList;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.enun.TipoHotel;

@Entity
@Table(name = "TB_HOTEL")
@SequenceGenerator(name = "hotel", sequenceName = "SP_TB_HOTEL", allocationSize = 1)
public class Hotel {

	@Id
	@Column(name = "cd_hotel")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotel")
	private int codigo;
	
	@Column(name = "nm_nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name = "ed_endereco", length = 150)
	private String endereco;
	
	@Column(name = "tp_tipo")
	@Enumerated(EnumType.STRING)
	private TipoHotel tipo;
	
	@Column(name = "av_avaliacao")
	private String avaliacao;
	
	@ManyToMany(mappedBy = "hoteis")
	private List<Estado> estado;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Reserva> reservas;
	
	public void addReserva(Reserva reserva) {
		if (reservas == null)
			reservas = new ArrayList<>();
		reservas.add(reserva);
		reserva.setHotel(this);
	}

	public Hotel() {
	}
	
	
	
	public Hotel(String nome, String endereco, TipoHotel tipo, String avaliacao) {
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.avaliacao = avaliacao;
	}

	public Hotel(String nome, String endereco, TipoHotel tipo, String avaliacao, List<Estado> estado,
			List<Reserva> reservas) {
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.avaliacao = avaliacao;
		this.estado = estado;
		this.reservas = reservas;
	}



	public Hotel(int codigo, String nome, String endereco, TipoHotel tipo, String avaliacao, List<Estado> estado,
			List<Reserva> reservas) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.tipo = tipo;
		this.avaliacao = avaliacao;
		this.estado = estado;
		this.reservas = reservas;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public TipoHotel getTipo() {
		return tipo;
	}

	public void setTipo(TipoHotel tipo) {
		this.tipo = tipo;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public List<Estado> getEstado() {
		return estado;
	}

	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
}










