package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication

public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	private IHotelService hotelService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Hotel h1 = new Hotel();
		h1.setNombre("Decameron");
		h1.setDescripcion("5 estrellas");
		Hotel h2 = new Hotel();
		h2.setNombre("Marriot");
		h2.setDescripcion("4 estrellas");
		Hotel h3 = new Hotel();
		h3.setNombre("Bio Vital");
		h3.setDescripcion("3 estrellas");

		Habitacion hab1 = new Habitacion();
		hab1.setNumero("H1");
		hab1.setTipo("VIP");
		hab1.setPrecio(BigDecimal.valueOf(100));
		hab1.setHotel(h1);
		Habitacion hab2 = new Habitacion();
		hab2.setNumero("H2");
		hab2.setTipo("NORMAL");
		hab2.setPrecio(BigDecimal.valueOf(50));
		hab2.setHotel(h2);
		Habitacion hab3 = new Habitacion();
		hab3.setNumero("H3");
		hab3.setTipo("NORMAL");
		hab3.setPrecio(BigDecimal.valueOf(60));
		hab3.setHotel(h2);
		Habitacion hab4 = new Habitacion();
		hab4.setNumero("H4");
		hab4.setTipo("VIP");
		hab4.setPrecio(BigDecimal.valueOf(150));
		hab4.setHotel(h1);
		List<Habitacion> habitaciones1 = new ArrayList<>();
		habitaciones1.add(hab1);
		habitaciones1.add(hab4);
		List<Habitacion> habitaciones2 = new ArrayList<>();
		habitaciones2.add(hab2);
		habitaciones2.add(hab3);

		h1.setHabitaciones(habitaciones1);
		h2.setHabitaciones(habitaciones2);
		/*
		this.hotelService.guardar(h1);
		this.hotelService.guardar(h2);
		this.hotelService.guardar(h3);
		 */
		System.err.println("Inner Join");
		List<Hotel> hoteles = this.hotelService.buscarHotelInnerJoin();
		for (Hotel hotel : hoteles) {
			System.out.println(hotel);
		}

		System.err.println("Right Join");
		List<Hotel> hoteles2 = this.hotelService.buscarHotelRightJoin();
		for (Hotel hotel : hoteles2) {
			System.out.println(hotel);
		}
		System.err.println("Left Join");
		List<Hotel> hoteles3 = this.hotelService.buscarHotelLeftJoin();
		for (Hotel hotel : hoteles3) {
			System.out.println(hotel);
		}
		System.err.println("Full Join");
		List<Hotel> hoteles4 = this.hotelService.buscarHotelFullJoin();
		for (Hotel hotel : hoteles4) {
			System.out.println(hotel);
			for (Habitacion habitacion : hotel.getHabitaciones()) {
				System.out.println(habitacion);
			}
		}
		
	}

}
