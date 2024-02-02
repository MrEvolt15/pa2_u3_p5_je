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
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_historia_clinica")
    @SequenceGenerator(name = "seq_historia_clinica", sequenceName = "seq_historia_clinica", allocationSize = 1)
    @Column(name = "hist_id")
    private Integer id;
    @Column(name = "hist_afeccion")
    private String afeccion;
    @Column(name = "hist_mci")
    private Integer MCI;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paci_id_hist")
    private Paciente paciente;

    //SETS Y GETS
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getAfeccion() {
        return afeccion;
    }
    public void setAfeccion(String afeccion) {
        this.afeccion = afeccion;
    }
    public Integer getMCI() {
        return MCI;
    }
    public void setMCI(Integer mCI) {
        MCI = mCI;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    
}
