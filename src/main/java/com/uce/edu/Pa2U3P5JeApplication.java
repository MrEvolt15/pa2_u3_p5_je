package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Biblioteca;
import com.uce.edu.ventas.repository.modelo.HistoriaClinica;
import com.uce.edu.ventas.repository.modelo.Libro;
import com.uce.edu.ventas.repository.modelo.Paciente;
import com.uce.edu.ventas.service.IBibliotecaService;
import com.uce.edu.ventas.service.IPacienteService;

@SpringBootApplication

public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	private IPacienteService iPacienteService;
	@Autowired
	private IBibliotecaService bibliotecaService;
	

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Paciente p1 = new Paciente();
		p1.setCedula("123");
		p1.setNombre("Juan");

		Paciente p2 = new Paciente();
		p2.setCedula("456");
		p2.setNombre("Joel");

		HistoriaClinica h1 = new HistoriaClinica();
		h1.setAfeccion("dolor rodilla");
		h1.setMCI(78);
		h1.setPaciente(p2);

		List<HistoriaClinica> historias = new ArrayList<>();
		historias.add(h1);
		p2.setHistoriaClinicas(historias);

		Biblioteca b1 = new Biblioteca();
		b1.setCodigo("412l");
		b1.setNombre("Laco");

		Biblioteca b2 = new Biblioteca();
		b2.setCodigo("789a");
		b2.setNombre("Alpa");

		Libro lib = new Libro();
		lib.setCopias(5);
		lib.setNombre("Java");
		lib.setBiblioteca(b1);

		List<Libro> libros = new ArrayList<>();
		libros.add(lib);
		b1.setLibros(libros);

		this.bibliotecaService.guardar(b2);
		this.bibliotecaService.guardar(b1);

		this.iPacienteService.guardar(p2);
		this.iPacienteService.guardar(p1);

		this.bibliotecaService.buscarBibliotecaFetchJoin();
		this.bibliotecaService.buscarBibliotecaFullJoin();
		this.bibliotecaService.buscarBibliotecaInnerJoin();
		this.bibliotecaService.buscarBibliotecaLeftJoin();
		this.bibliotecaService.buscarBibliotecaRightJoin();

		this.iPacienteService.buscarPacienteFetchJoin();
		this.iPacienteService.buscarPacienteFullJoin();
		this.iPacienteService.buscarPacienteInnerJoin();
		this.iPacienteService.buscarPacienteLeftJoin();
		this.iPacienteService.buscarPacienteRightJoin();
		
	}

}
