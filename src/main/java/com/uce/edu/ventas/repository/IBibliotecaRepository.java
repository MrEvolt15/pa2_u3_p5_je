package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Biblioteca;

public interface IBibliotecaRepository {
    public void insertar(Biblioteca biblioteca);
    public List<Biblioteca> seleccionarBibliotecaInnerJoin();
    public List<Biblioteca> seleccionarBibliotecaRightJoin();
    public List<Biblioteca> seleccionarBibliotecaLeftJoin();
    public List<Biblioteca> seleccionarBibliotecaFullJoin();
    public List<Biblioteca> seleccionarBibliotecaFetchJoin();
}
