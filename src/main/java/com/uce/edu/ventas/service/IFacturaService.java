package com.uce.edu.ventas.service;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaService {
    public void guardar(Factura factura,Cliente cliente);
    public Factura buscarPorNumero(String numero);
    public List<Factura> buscarFacturasInnerJoin();
    public List<Factura> buscarFacturasRightJoin();
    public List<Factura> buscarFacturasLeftJoin();
    public List<Factura> buscarFacturasFullJoin();

    public List<Factura> buscarFacturasJoinWhere();
    public List<Factura> buscarFacturasFetchJoin();
    public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual);
    public void borrar(Integer id);
    public int borrarPorNumero(String numero);

    public List<FacturaDTO> buscarFacturasDTO();

    public void prueba();
}
