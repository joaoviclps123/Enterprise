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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.fiap.enun.ClasseCliente;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "cliente", sequenceName = "SP_TB_CLIENTE", allocationSize = 1)
public class Cliente {
	
	@Id
	@Column(name = "cd_codigo")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente")
	private int codigo;
	
	@Column(name = "nm_nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name = "cl_classe")
	@Enumerated(EnumType.STRING)
	private ClasseCliente classe;
	
	@Column(name = "cfj_cpf_cnpj", nullable = false)
	private int cpf_cnpj;
	
	@Column(name = "nm_telefone")
	private int telefone;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Reserva> reservas;
	
	public void addReserva(Reserva reserva) {
		if (reservas == null)
			reservas = new ArrayList<>();
		reservas.add(reserva);
		reserva.setCliente(this);
	}
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cd_cliente")
	private Pagamento pagamento;
	
	public Cliente() {
	}
	
	
	
	public Cliente(String nome, ClasseCliente classe, int cpf_cnpj, int telefone) {
		this.nome = nome;
		this.classe = classe;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
	}

	


	public Cliente(String nome, ClasseCliente classe, int cpf_cnpj, int telefone, Pagamento pagamento) {
		this.nome = nome;
		this.classe = classe;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
		this.pagamento = pagamento;
	}



	public Cliente(String nome, ClasseCliente classe, int cpf_cnpj, int telefone, List<Reserva> reservas,
			Pagamento pagamento) {
		this.nome = nome;
		this.classe = classe;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
		this.reservas = reservas;
		this.pagamento = pagamento;
	}

	public Cliente(int codigo, String nome, ClasseCliente classe, int cpf_cnpj, int telefone, List<Reserva> reservas,
			Pagamento pagamento) {
		this.codigo = codigo;
		this.nome = nome;
		this.classe = classe;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone = telefone;
		this.reservas = reservas;
		this.pagamento = pagamento;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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

	public ClasseCliente getClasse() {
		return classe;
	}

	public void setClasse(ClasseCliente classe) {
		this.classe = classe;
	}

	public int getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(int cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	
	
}
