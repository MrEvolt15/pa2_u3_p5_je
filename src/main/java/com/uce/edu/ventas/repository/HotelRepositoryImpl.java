package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void insertar(Hotel hotel) {
        this.entityManager.persist(hotel);
    }

    @Override
    public List<Hotel> seleccionarHotelInnerJoin() {
        TypedQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h inner join h.habitaciones ha", Hotel.class);
        List<Hotel> hoteles = query.getResultList();
        for (Hotel hotel : hoteles) {
            hotel.getHabitaciones().size();
        }
        return hoteles;
    }

    @Override
    public List<Hotel> seleccionarHotelLeftJoin() {
        TypedQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h left join h.habitaciones ha", Hotel.class);
        List<Hotel> hoteles = query.getResultList();
        for (Hotel hotel : hoteles) {
            hotel.getHabitaciones().size();
        }
        return hoteles;
    }

    @Override
    public List<Hotel> seleccionarHotelRightJoin() {
        TypedQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h right join h.habitaciones ha", Hotel.class);
        List<Hotel> hoteles = query.getResultList();
        for (Hotel hotel : hoteles) {
            hotel.getHabitaciones().size();
        }
        return hoteles;
    }

    @Override
    public List<Hotel> seleccionarHotelFullJoin() {
        TypedQuery<Hotel> query = this.entityManager.createQuery("select h from Hotel h full join h.habitaciones ha", Hotel.class);
        List<Hotel> hoteles = query.getResultList();
        for (Hotel hotel : hoteles) {
            hotel.getHabitaciones().size();
        }
        return hoteles;
    }

}
