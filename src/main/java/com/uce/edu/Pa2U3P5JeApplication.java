package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.service.IClienteService;

@SpringBootApplication
@EnableAsync
public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	//private IFacturaService facturaService;
	private IClienteService clienteService;
	
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		/* 
		//Programacion Sincrona 1 hilo
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for(int i=1;i<=100;i++){
			Cliente cli = new Cliente();
			cli.setNombre("CN"+i);
			cli.setApellido("CA"+i);
			this.clienteService.guardar(cli);
		}
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("Tiempo total: "+(tiempoFinal-tiempoInicial));
		*/
		//Programacion en Paralelo
		/* 
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listaCli = new ArrayList<>();
		for(int i=1;i<=100;i++){
			Cliente cli = new Cliente();
			cli.setNombre("CN"+i);
			cli.setApellido("CA"+i);
			listaCli.add(cli);
		}
		listaCli.parallelStream().forEach(cliente -> this.clienteService.guardar(cliente));
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("Tiempo total: "+(tiempoFinal-tiempoInicial));
		*/
		//Programacion Asincrona
		System.out.println("Nombre hilo: "+Thread.currentThread().getName());
		long tiempoInicial = System.currentTimeMillis();
		for(int i=1;i<=100;i++){
			Cliente cli = new Cliente();
			cli.setNombre("CN"+i);
			cli.setApellido("CA"+i);
			this.clienteService.guardar(cli);
		}
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("Tiempo total: "+(tiempoFinal-tiempoInicial));
		System.out.println("Se ha mandado a procesar sus 500 estudiantes");
	}

}
