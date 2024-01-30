package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
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
		System.err.println("Inner Join");
		List<Factura> facturas2 = this.facturaService.buscarFacturasInnerJoin();
		for (Factura factura : facturas2) {
			System.out.println(factura.getNumero());
		//	for (DetalleFactura detalle  : factura.getDetalleFacturas()) {
		//		System.out.println(detalle.getNombreProd());
		//	}
		}
		System.err.println("Where Join");
		List<Factura> facturas = this.facturaService.buscarFacturasJoinWhere();
		for (Factura factura : facturas) {
			System.out.println(factura.getNumero());
			for (DetalleFactura detalle  : factura.getDetalleFacturas()) {
				System.out.println(detalle.getNombreProd());
			}
		}
		System.err.println("Fetch Join");
		List<Factura> facturas3 = this.facturaService.buscarFacturasFetchJoin();
		for (Factura factura : facturas3) {
			System.out.println(factura.getNumero());
			for (DetalleFactura detalle  : factura.getDetalleFacturas()) {
				System.out.println(detalle.getNombreProd());
			}
		}
	}

}
