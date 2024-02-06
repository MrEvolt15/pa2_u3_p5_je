package com.uce.edu.ventas.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService{
    @Autowired
    private IFacturaRepository facturaRepository;
    @Autowired
    private IClienteService clienteService;
    @Override
    @Transactional(value = TxType.REQUIRED)//T1
    public void guardar(Factura factura,Cliente cliente) {
        System.out.println(TransactionSynchronizationManager.isActualTransactionActive()); 
        System.out.println("Paso el insert de factura");
        this.facturaRepository.insertar(factura);
        System.out.println("Paso el insert de cliente");
        this.clienteService.guardar(cliente);
    }
    /*
     * T1 begin
     * insert factura (ok)
     * insert cliente (ok)
     * commit
     * T1 begin
     * insert factura (ok)
     * insert cliente (error)
     * commit
     */
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
    @Override
    @Transactional(value = TxType.MANDATORY)//Obliga a que desde donde se lo llama tenga una transaccion
    public void prueba() {
         
        System.out.println("Este metodo es de prueba");
        System.out.println("Prueba: "+TransactionSynchronizationManager.isActualTransactionActive());
    }

}
