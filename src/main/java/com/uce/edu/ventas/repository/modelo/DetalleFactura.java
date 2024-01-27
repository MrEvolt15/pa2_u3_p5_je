package com.uce.edu.ventas.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_detalle_factura")
    @SequenceGenerator(name = "seq_detalle_factura", sequenceName = "seq_detalle_factura", allocationSize = 1)
    @Column(name = "defa_id")
    private Integer id;
    @Column(name = "defa_cantidad")
    private Integer cantidad;
    @Column(name = "defa_codigo_barras")
    private String codBarras;
    @Column(name = "defa_nombre_producto")
    private String nombreProd;
    @ManyToOne
    @JoinColumn(name = "fact_defa_id")
    private Factura factura;

    //SETS Y GETS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getCodBarras() {
        return codBarras;
    }
    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }
    public String getNombreProd() {
        return nombreProd;
    }
    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }
    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    @Override
    public String toString() {
        return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", codBarras=" + codBarras + ", nombreProd="
                + nombreProd + "]";
    }

    
}
