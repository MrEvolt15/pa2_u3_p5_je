package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHotelRepository;
import com.uce.edu.ventas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{
    @Autowired
    private IHotelRepository hotelRepository;
    @Override
    public void guardar(Hotel hotel) {
        this.hotelRepository.insertar(hotel);
    }

    @Override
    public List<Hotel> buscarHotelInnerJoin() {
        return this.hotelRepository.seleccionarHotelInnerJoin();
    }

    @Override
    public List<Hotel> buscarHotelLeftJoin() {
        return this.hotelRepository.seleccionarHotelLeftJoin();
    }

    @Override
    public List<Hotel> buscarHotelRightJoin() {
        return this.hotelRepository.seleccionarHotelRightJoin();
    }

    @Override
    public List<Hotel> buscarHotelFullJoin() {
        return this.hotelRepository.seleccionarHotelFullJoin();
    }

}
