package com.uce.edu;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.RSocket.Client;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication

public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	private IFacturaService facturaService;
	private IClienteService clienteService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Main: "+TransactionSynchronizationManager.isActualTransactionActive());
		Factura fac = new Factura();
		fac.setCedula("456");
		fac.setFecha(LocalDate.now());
		fac.setNumero("0007");

		Cliente cli = new Cliente();
		cli.setApellido(null);
		cli.setNombre("Joel");

		//this.facturaService.guardar(fac,cli);
		this.facturaService.prueba();
	}

}
