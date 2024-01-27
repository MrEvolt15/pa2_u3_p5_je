package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaRepository {
    public void insertar(Factura factura);
    public Factura seleccionarPorNumero(String numero);

    public List<Factura> seleccionarFacturasInnerJoin();
    public List<Factura> seleccionarFacturasRightJoin();
    public List<Factura> seleccionarFacturasLeftJoin();
    public List<Factura> seleccionarFacturasFullJoin();
}
