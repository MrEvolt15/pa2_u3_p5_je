package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IBibliotecaRepository;
import com.uce.edu.ventas.repository.modelo.Biblioteca;

@Service
public class BibliotecaServiceImpl implements IBibliotecaService{
    @Autowired
    private IBibliotecaRepository bibliotecaRepository;
    @Override
    public void guardar(Biblioteca biblioteca) {
        this.bibliotecaRepository.insertar(biblioteca);
    }

    @Override
    public List<Biblioteca> buscarBibliotecaInnerJoin() {
        return this.bibliotecaRepository.seleccionarBibliotecaInnerJoin();
    }

    @Override
    public List<Biblioteca> buscarBibliotecaRightJoin() {
        return this.bibliotecaRepository.seleccionarBibliotecaRightJoin();
    }

    @Override
    public List<Biblioteca> buscarBibliotecaLeftJoin() {
        return this.bibliotecaRepository.seleccionarBibliotecaLeftJoin();
    }

    @Override
    public List<Biblioteca> buscarBibliotecaFullJoin() {
        return this.bibliotecaRepository.seleccionarBibliotecaFullJoin();
    }

    @Override
    public List<Biblioteca> buscarBibliotecaFetchJoin() {
        return this.bibliotecaRepository.seleccionarBibliotecaFetchJoin();
    }

}
