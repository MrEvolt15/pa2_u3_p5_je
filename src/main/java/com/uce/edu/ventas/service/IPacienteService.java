package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Paciente;

public interface IPacienteService {
    public void guardar(Paciente paciente);
    
    public List<Paciente> buscarPacienteInnerJoin();
    public List<Paciente> buscarPacienteLeftJoin();
    public List<Paciente> buscarPacienteRightJoin();
    public List<Paciente> buscarPacienteFullJoin();
    public List<Paciente> buscarPacienteFetchJoin();
}
