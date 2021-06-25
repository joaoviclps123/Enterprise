package br.com.fiap.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.EstadoDao;
import br.com.fiap.dao.HotelDao;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Hotel;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.entity.Reserva;
import br.com.fiap.enun.ClasseCliente;
import br.com.fiap.enun.ModPagamento;
import br.com.fiap.enun.Objetivo;
import br.com.fiap.enun.TipoHotel;
import br.com.fiap.enun.TipoPessoa;
import br.com.fiap.enun.Zona;
import br.com.fiap.exeption.CommitException;
import br.com.fiap.exeption.EntityNotFoundException;
import br.com.fiap.interfaces.EstadoInterface;
import br.com.fiap.interfaces.HotelInterface;
import br.com.fiap.sigleton.EntityManagerFactorySingleton;

public class CadastroDados {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		EstadoInterface estadoDao = new EstadoDao(em);
		
		HotelInterface hotelDao = new HotelDao(em);
		
		Estado estado = new Estado("Sao Paulo", 760, Zona.SUDESTE, "Brasil");
		Estado estado2 = new Estado("Sao Paulo", 760, Zona.SUDESTE, "Brasil");
		
		
		Hotel hotel = new Hotel("Confort Ibirapuera", "Av. Roque petroni Júnior, 1000-Vilia Gertudes, Sao Paulo-SP, 04707-000", TipoHotel.APARTAMENTO, "3 estrelas");
		Hotel hotel2 = new Hotel("Buorbon Convention Ibirapuera", "Av.ibirapuera,2927 - ibirapuera, Sao Paulo - SP, 04029200", null, null);
		
		Cliente cli = new Cliente("Victor Fernando", ClasseCliente.PF, 457872668, 998019210);
		Pagamento pag = new Pagamento(ModPagamento.DEBIDO, "MasterCard", "Victorfernando@gmail.com", new GregorianCalendar(2030, Calendar.AUGUST, 0), cli);
		
		Reserva reserva = new Reserva(187, new GregorianCalendar(2021, Calendar.APRIL, 21), new GregorianCalendar(2021, Calendar.APRIL, 25), 1, TipoPessoa.ADULTO, Objetivo.OUTROS, 3);
		Reserva reserva2 = new Reserva(187, new GregorianCalendar(2021, Calendar.APRIL, 2), new GregorianCalendar(2021, Calendar.APRIL, 10), 2, TipoPessoa.ADULTO, Objetivo.OUTROS, 6);
		
		hotel.addReserva(reserva);
		hotel.addReserva(reserva2);
		cli.addReserva(reserva);

		List<Hotel> hoteis = new ArrayList<>();
		hoteis.add(hotel);
		hoteis.add(hotel2);
		
		estado.setHoteis(hoteis);
		estado2.setHoteis(hoteis);

		hotelDao.create(hotel);
		
		try {
			hotelDao.commit();
			System.out.println("cadastrados");
		}catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			Hotel hotelPes = hotelDao.read(1);
			System.out.println("Hotel: " + hotel.getNome());
			System.out.println("Cliente: " + cli.getPagamento());
			System.out.println("Reserva: ");
			List<Reserva> reservas = reserva.getHotel().getReservas();
			for (Reserva reserv : reservas) {
				System.out.println(reserv.getPreco());
				System.out.println("Precos: ");
			}
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}









