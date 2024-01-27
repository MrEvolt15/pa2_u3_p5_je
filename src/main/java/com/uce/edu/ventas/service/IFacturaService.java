package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;

public interface IFacturaService {
    public void guardar(Factura factura);
    public Factura buscarPorNumero(String numero);
    public List<Factura> buscarFacturasInnerJoin();
    public List<Factura> buscarFacturasRightJoin();
    public List<Factura> buscarFacturasLeftJoin();
    public List<Factura> buscarFacturasFullJoin();
}
