package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Factura factura) {
        this.entityManager.persist(factura);
    }
    @Override
    public Factura seleccionarPorNumero(String numero) {
       TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero", Factura.class);
       query.setParameter("numero", numero);
       Factura fact = query.getSingleResult();
       fact.getDetalleFacturas().size(); // le digo que cargue el detalle bajo demanda
       return fact;
    }
    @Override
    public List<Factura> seleccionarFacturasInnerJoin() {
        //SQL: SELECT * FROM factura f inner join detalle_factura d on f.fact_id = d.defa_id_fact
        //JPQL: select f from Factura f inner join f.detalleFactura d

        //select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.fact_defa_id
        //select f from Factura f innner join f.detalleFacturas d

        //select f1_0.fact_id,f1_0.fact_cedula,f1_0.fact_fecha,f1_0.fact_numero from factura f1_0 join detalle_factura df1_0 on f1_0.fact_id=df1_0.fact_defa_id
        //select f from Factura f join f.detalleFacturas d

        TypedQuery<Factura> query = this.entityManager.createQuery("select f from Factura f join f.detalleFacturas d", Factura.class);
        List<Factura> facturas = query.getResultList();
        for (Factura factura : facturas) {
            factura.getDetalleFacturas().size();
        }
        return facturas;
    }
    @Override
    public List<Factura> seleccionarFacturasRightJoin() {

        TypedQuery<Factura> query = this.entityManager.createQuery("select f from Factura f right join f.detalleFacturas d", Factura.class);
        List<Factura> facturas = query.getResultList();
        for (Factura factura : facturas) {
            factura.getDetalleFacturas().size();
        }
        return facturas;
    }
    @Override
    public List<Factura> seleccionarFacturasLeftJoin() {
        TypedQuery<Factura> query = this.entityManager.createQuery("select f from Factura f left join f.detalleFacturas d", Factura.class);
        List<Factura> facturas = query.getResultList();
        for (Factura factura : facturas) {
            factura.getDetalleFacturas().size();
        }
        return facturas;
    }
    @Override
    public List<Factura> seleccionarFacturasFullJoin() {
        TypedQuery<Factura> query = this.entityManager.createQuery("select f from Factura f full join f.detalleFacturas d", Factura.class);
        List<Factura> facturas = query.getResultList();
        for (Factura factura : facturas) {
            factura.getDetalleFacturas().size();
        }
        return facturas;
    }

}
