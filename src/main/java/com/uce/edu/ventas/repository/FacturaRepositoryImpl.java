package com.uce.edu.ventas.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
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
    //    for (Factura factura : facturas) {
    //        factura.getDetalleFacturas().size();
    //    }
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
    @Override
    public List<Factura> seleccionarFacturasJoinWhere() {
        //SQL: SELECT f.* FROM factura f, detalle_factura d WHERE f.fact_id = d.defa_if_factura
        //JPQL: SELECT f FROM Factura f, DetalleFactura d WHERE f.fact_id = d.factura.id
        //                                                WHERE f = d.factura
        TypedQuery<Factura> query = this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura", Factura.class);
        List<Factura> facturas = query.getResultList();
        for (Factura factura : facturas) {
            factura.getDetalleFacturas().size();
        }
        return facturas;
    }
    //Fetch join es mucho mas eficiente en terminos de numeros de consultas
    //Native query es mucho mas rapido
    @Override
    public List<Factura> seleccionarFacturasFetchJoin() {
        //Inner Join: select f from Factura f join f.detalleFactura d
        //select f from Factura f join fetch f.detalleFactura d
        TypedQuery<Factura> query = this.entityManager.createQuery("select f from Factura f join fetch f.detalleFacturas d", Factura.class);
        List<Factura> facturas = query.getResultList();
        
        return facturas;
    }
    @Override
    public void actualizar(Factura factura) {
        this.entityManager.merge(factura);
    }
    @Override
    public int actualizarFechas(LocalDate fechaNueva, LocalDate fechaActual) {
        //select * from Factura f where f.fecha>=fechaActual
        //lista
        //recorrer la lista
        //por cada factura seteo la nueva fecha
        //actualizar cada factura
        //SQL: Update factura set fact_fecha =:fechaNueva where fact_fecha >=fechaActual
        //JPQL: Update Factura f set f.fecha = :fechaNueva where f.fecha >= :fechaActual
        Query query = this.entityManager.createQuery("Update Factura f set f.fecha = :fechaNueva where f.fecha >= :fechaActual");
        query.setParameter("fechaNueva", fechaNueva);
        query.setParameter("fechaActual", fechaActual);
        return query.executeUpdate();
        //devuelve un entero que son la cantidad de registros afectados-actualizados
    }
    @Override
    public void eliminar(Integer id) {
        //aqui si tengo el objeto
        //contiene los datos de la relacion (detalleFactura)
        //aqui si se elimina en cascada
        this.entityManager.remove(this.entityManager.find(Factura.class, id));
    }
    @Override
    public int eliminarPorNumero(String numero) {
        //SQL: delete from factura where fact_numero = :numero
        //JPQL: delete from Factura f where f.numero = :numero
        Query query = this.entityManager.createQuery("delete from Factura f where f.numero = :numero");
        query.setParameter("numero", numero);
        return query.executeUpdate();
    }
    @Override
    public List<FacturaDTO> seleccionarFacturasDTO() {
        TypedQuery<FacturaDTO> query = this.entityManager.createQuery("select new com.uce.edu.ventas.repository.modelo.dto.FacturaDTO(f.numero, f.fecha) from Factura f ",FacturaDTO.class);
        return query.getResultList();
    }

}
