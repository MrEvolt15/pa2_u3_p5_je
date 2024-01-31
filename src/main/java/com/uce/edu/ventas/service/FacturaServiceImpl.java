package com.uce.edu.ventas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

@Service
public class FacturaServiceImpl implements IFacturaService{
    @Autowired
    private IFacturaRepository facturaRepository;
    @Override
    public void guardar(Factura factura) {
        this.facturaRepository.insertar(factura);
    }

    @Override
    public Factura buscarPorNumero(String numero) {
        return this.facturaRepository.seleccionarPorNumero(numero);
    }

    @Override
    public List<Factura> buscarFacturasInnerJoin() {
        return this.facturaRepository.seleccionarFacturasInnerJoin();
    }

    @Override
    public List<Factura> buscarFacturasRightJoin() {
        return this.facturaRepository.seleccionarFacturasRightJoin();
    }

    @Override
    public List<Factura> buscarFacturasLeftJoin() {
        return this.facturaRepository.seleccionarFacturasLeftJoin();
    }

    @Override
    public List<Factura> buscarFacturasFullJoin() {
        return this.facturaRepository.seleccionarFacturasFullJoin();
    }

    @Override
    public List<Factura> buscarFacturasJoinWhere() {
        return this.facturaRepository.seleccionarFacturasJoinWhere();
    }

    @Override
    public List<Factura> buscarFacturasFetchJoin() {
        return this.facturaRepository.seleccionarFacturasFetchJoin();
    }

    @Override
    public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual) {
        return this.facturaRepository.actualizarFechas(fechaNueva, fechaActual);
    }

    @Override
    public int borrarPorNumero(String numero) {
        return this.facturaRepository.eliminarPorNumero(numero);
    }

    @Override
    public void borrar(Integer id) {
        this.facturaRepository.eliminar(id);
    }

    @Override
    public List<FacturaDTO> buscarFacturasDTO() {
        return this.facturaRepository.seleccionarFacturasDTO();
    }

}
