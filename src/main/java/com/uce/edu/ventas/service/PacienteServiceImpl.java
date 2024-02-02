package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IPacienteRepository;
import com.uce.edu.ventas.repository.modelo.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{
    @Autowired
    private IPacienteRepository iPacienteRepository;
    @Override
    public void guardar(Paciente paciente) {
        this.iPacienteRepository.insertar(paciente);
    }

    @Override
    public List<Paciente> buscarPacienteInnerJoin() {
        return this.iPacienteRepository.seleccionarPacienteInnerJoin();
    }

    @Override
    public List<Paciente> buscarPacienteLeftJoin() {
        return this.iPacienteRepository.seleccionarPacienteLeftJoin();
    }

    @Override
    public List<Paciente> buscarPacienteRightJoin() {
        return this.iPacienteRepository.seleccionarPacienteRightJoin();
    }

    @Override
    public List<Paciente> buscarPacienteFullJoin() {
        return this.iPacienteRepository.seleccionarPacienteFullJoin();
    }

    @Override
    public List<Paciente> buscarPacienteFetchJoin() {
        return this.iPacienteRepository.seleccionarPacienteFetchJoin();
    }

}
