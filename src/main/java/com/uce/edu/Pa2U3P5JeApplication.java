package com.uce.edu;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication

public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	private IFacturaService facturaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Update");
		int cantidad = this.facturaService.actualizarFechas(LocalDate.of(2020, 1, 15), LocalDate.of(2024, 1, 1));
		System.out.println("Cantidad de registros afectados");
		System.out.println(cantidad);
		System.err.println("Delete por Numero");
		int cantidad2 = this.facturaService.borrarPorNumero("001-7985");
		System.out.println("Cantidad de registros afectados");
		System.out.println(cantidad2);
		System.err.println("Delete Normal");
		//this.facturaService.borrar(1);


		//DTO: Data Transfer Object - Patron de diseño: permite transferir datos entre la capa repo a la capa service 

		System.out.println("Objeto DTO");
		for (FacturaDTO facturaDTO : this.facturaService.buscarFacturasDTO()) {
			System.out.println(facturaDTO);
		}
	}

}
