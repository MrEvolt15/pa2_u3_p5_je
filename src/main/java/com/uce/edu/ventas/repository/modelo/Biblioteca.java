package com.uce.edu.ventas.repository.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_biblioteca")
    @SequenceGenerator(name = "seq_biblioteca", sequenceName = "seq_biblioteca", allocationSize = 1)
    @Column(name = "bibl_id")
    private Integer id;
    @Column(name = "bibl_nombre")
    private String nombre;
    @Column(name = "bibl_codigo")
    private String codigo;
    @OneToMany(mappedBy = "biblioteca",cascade = CascadeType.ALL)
    private List<Libro> libros;

    //SETS Y GETS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public List<Libro> getLibros() {
        return libros;
    }
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    
}
