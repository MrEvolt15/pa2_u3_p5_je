package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Biblioteca;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class BibliotecaRepositoryImpl implements IBibliotecaRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Biblioteca biblioteca) {
        this.entityManager.persist(biblioteca);
    }

    @Override
    public List<Biblioteca> seleccionarBibliotecaInnerJoin() {
        TypedQuery<Biblioteca> query = this.entityManager.createQuery("select b from Biblioteca b inner join b.libros l", Biblioteca.class);
        List<Biblioteca> bibliotecas = query.getResultList();
        for (Biblioteca biblioteca : bibliotecas) {
            biblioteca.getLibros().size();
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> seleccionarBibliotecaRightJoin() {
        TypedQuery<Biblioteca> query = this.entityManager.createQuery("select b from Biblioteca b right join b.libros l", Biblioteca.class);
        List<Biblioteca> bibliotecas = query.getResultList();
        for (Biblioteca biblioteca : bibliotecas) {
            biblioteca.getLibros().size();
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> seleccionarBibliotecaLeftJoin() {
        TypedQuery<Biblioteca> query = this.entityManager.createQuery("select b from Biblioteca b left join b.libros l", Biblioteca.class);
        List<Biblioteca> bibliotecas = query.getResultList();
        for (Biblioteca biblioteca : bibliotecas) {
            biblioteca.getLibros().size();
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> seleccionarBibliotecaFullJoin() {
        TypedQuery<Biblioteca> query = this.entityManager.createQuery("select b from Biblioteca b full join b.libros l", Biblioteca.class);
        List<Biblioteca> bibliotecas = query.getResultList();
        for (Biblioteca biblioteca : bibliotecas) {
            biblioteca.getLibros().size();
        }
        return bibliotecas;
    }

    @Override
    public List<Biblioteca> seleccionarBibliotecaFetchJoin() {
        TypedQuery<Biblioteca> query = this.entityManager.createQuery("select b from Biblioteca b join fetch b.libros l", Biblioteca.class);
        
        return query.getResultList();
    }

}
