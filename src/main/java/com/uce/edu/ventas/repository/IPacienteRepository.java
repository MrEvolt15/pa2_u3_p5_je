package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Paciente;

public interface IPacienteRepository {
    public void insertar(Paciente paciente);
    
    public List<Paciente> seleccionarPacienteInnerJoin();
    public List<Paciente> seleccionarPacienteLeftJoin();
    public List<Paciente> seleccionarPacienteRightJoin();
    public List<Paciente> seleccionarPacienteFullJoin();
    public List<Paciente> seleccionarPacienteFetchJoin();
}
