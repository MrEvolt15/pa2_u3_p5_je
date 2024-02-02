package com.uce.edu.ventas.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "libro3")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro_3")
    @SequenceGenerator(name = "seq_libro_3", sequenceName = "seq_libro_3", allocationSize = 1)
    @Column(name = "lib_id")
    private Integer id;
    @Column(name = "lib_nombre")
    private String nombre;
    @Column(name = "lib_copias")
    private Integer copias;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lib_id_bibl")
    private Biblioteca biblioteca;

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
    public Integer getCopias() {
        return copias;
    }
    public void setCopias(Integer copias) {
        this.copias = copias;
    }
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    
}
