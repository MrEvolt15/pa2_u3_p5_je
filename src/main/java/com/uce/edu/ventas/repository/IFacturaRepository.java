package com.uce.edu.ventas.repository;

import java.time.LocalDate;
import java.util.List;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

public interface IFacturaRepository {
    public void insertar(Factura factura);
    public void actualizar(Factura factura);
    public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual);
    public void eliminar(Integer id);
    public int eliminarPorNumero(String numero);

    public Factura seleccionarPorNumero(String numero);

    public List<Factura> seleccionarFacturasInnerJoin();
    public List<Factura> seleccionarFacturasRightJoin();
    public List<Factura> seleccionarFacturasLeftJoin();
    public List<Factura> seleccionarFacturasFullJoin();

    public List<Factura> seleccionarFacturasJoinWhere();
    public List<Factura> seleccionarFacturasFetchJoin();

    public List<FacturaDTO> seleccionarFacturasDTO();
}
