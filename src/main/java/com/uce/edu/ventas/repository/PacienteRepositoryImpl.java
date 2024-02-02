package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Paciente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class PacienteRepositoryImpl implements IPacienteRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Paciente paciente) {
        this.entityManager.persist(paciente);
    }

    @Override
    public List<Paciente> seleccionarPacienteInnerJoin() {
        TypedQuery<Paciente> query = this.entityManager.createQuery("select p from Paciente p inner join p.historiaClinicas hist", Paciente.class);
        List<Paciente> pacientes = query.getResultList();
        for (Paciente paciente : pacientes) {
            paciente.getHistoriaClinicas().size();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> seleccionarPacienteLeftJoin() {
        TypedQuery<Paciente> query = this.entityManager.createQuery("select p from Paciente p left join p.historiaClinicas hist", Paciente.class);
        List<Paciente> pacientes = query.getResultList();
        for (Paciente paciente : pacientes) {
            paciente.getHistoriaClinicas().size();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> seleccionarPacienteRightJoin() {
        TypedQuery<Paciente> query = this.entityManager.createQuery("select p from Paciente p right join p.historiaClinicas hist", Paciente.class);
        List<Paciente> pacientes = query.getResultList();
        for (Paciente paciente : pacientes) {
            paciente.getHistoriaClinicas().size();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> seleccionarPacienteFullJoin() {
        TypedQuery<Paciente> query = this.entityManager.createQuery("select p from Paciente p full join p.historiaClinicas hist", Paciente.class);
        List<Paciente> pacientes = query.getResultList();
        for (Paciente paciente : pacientes) {
            paciente.getHistoriaClinicas().size();
        }
        return pacientes;
    }

    @Override
    public List<Paciente> seleccionarPacienteFetchJoin() {
        TypedQuery<Paciente> query = this.entityManager.createQuery("select p from Paciente p join fetch p.historiaClinicas hist", Paciente.class);
        
        return query.getResultList();
    }

}
