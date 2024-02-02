package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Biblioteca;


public interface IBibliotecaService {
    public void guardar(Biblioteca biblioteca);
    public List<Biblioteca> buscarBibliotecaInnerJoin();
    public List<Biblioteca> buscarBibliotecaRightJoin();
    public List<Biblioteca> buscarBibliotecaLeftJoin();
    public List<Biblioteca> buscarBibliotecaFullJoin();
    public List<Biblioteca> buscarBibliotecaFetchJoin();
}
