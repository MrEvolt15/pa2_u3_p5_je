package com.uce.edu.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(value = TxType.REQUIRES_NEW)
    public void insertar(Cliente cliente) {
        System.out.println("Antes de ejecutar en la base");
        try {
            this.entityManager.persist(cliente);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        
        System.out.println("Despues de ejecutar en la base");
    }

}
