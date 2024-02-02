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
@Table(name ="paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    @SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", allocationSize = 1)
    @Column(name = "paci_id")
    private Integer id;
    @Column(name = "paci_nombre")
    private String nombre;
    @Column(name = "paci_cedula")
    private String cedula;
    @OneToMany(mappedBy = "paciente",cascade = CascadeType.ALL)
    private List<HistoriaClinica> historiaClinicas;

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
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public List<HistoriaClinica> getHistoriaClinicas() {
        return historiaClinicas;
    }
    public void setHistoriaClinicas(List<HistoriaClinica> historiaClinicas) {
        this.historiaClinicas = historiaClinicas;
    }

    
}
