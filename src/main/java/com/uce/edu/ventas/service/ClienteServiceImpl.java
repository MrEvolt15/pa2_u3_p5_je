package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService{
    @Autowired
    private IClienteRepository clienteRepository;


    @Override
    @Transactional(value = TxType.REQUIRES_NEW)//T2
    //begin
    public void guardar(Cliente cliente) {
        try {
            this.clienteRepository.insertar(cliente);
        } catch (RuntimeException e) {
            // TODO: handle exception
            System.out.println(e.getClass());
        }
        
    }//commit


    @Override
    @Transactional(value = TxType.SUPPORTS)
    public void pruebaSupports() {
        System.out.println("Este es un metodo supports!!");
        System.out.println("Prueba Supports: "+TransactionSynchronizationManager.isActualTransactionActive());
    }


    @Override
    @Transactional(value = TxType.NEVER)
    public void pruebaNever() {
        System.out.println("Este es un metodo never!!");
        System.out.println("Prueba Never: "+TransactionSynchronizationManager.isActualTransactionActive());
    }

}
