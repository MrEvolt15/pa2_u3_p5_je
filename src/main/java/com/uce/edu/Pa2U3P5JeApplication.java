package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
@ComponentScan("com.uce.edu")
public class Pa2U3P5JeApplication implements CommandLineRunner{

	//Join Types en JPA
    // 1) Join
    //1.1) Inner Join
    //1.2) Outer Join
    //  1.2.1)Right
    //  1.2.2)Left
    //  1.2.3)Full
    // 2) Join Where
    // 3) Fetch Join

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Inner Join");
		List<Factura> facturas = this.facturaService.buscarFacturasInnerJoin();
		for (Factura factura : facturas) {
			System.out.println(factura);
		}

		System.err.println("Right Join");
		List<Factura> facturas2 = this.facturaService.buscarFacturasRightJoin();
		for (Factura factura : facturas2) {
			System.out.println(factura);
		}
		System.err.println("Left Join");
		List<Factura> facturas3 = this.facturaService.buscarFacturasLeftJoin();
		for (Factura factura : facturas3) {
			System.out.println(factura);
		}
		System.err.println("Full Join");
		List<Factura> facturas4 = this.facturaService.buscarFacturasFullJoin();
		for (Factura factura : facturas4) {
			System.out.println(factura);
			for (DetalleFactura detalleFactura : factura.getDetalleFacturas()) {
				System.out.println(detalleFactura);
			}
		}
	}

}
