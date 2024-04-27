package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.BookingEntity;
import com.apigestion.hoteleria.persistence.Entity.EmployeeEntity;
import com.apigestion.hoteleria.persistence.Repository.BookingRepository;
import com.apigestion.hoteleria.persistence.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;

    @Autowired
    public BookingService(BookingRepository repository) {
        this.repository = repository;
    }
    public List<BookingEntity> getAll(){
        return this.repository.findAll();
    }
    public BookingEntity getByIdBooking(Integer idBooking){
        return this.repository.findById(idBooking).orElseThrow(()-> new RuntimeException("La reserva no existe"));
    }
    public BookingEntity save(BookingEntity booking){
        return this.repository.save(booking);
    }
    public void delete(Integer idBooking){
        this.repository.deleteById(idBooking);
    }
    public Boolean exists(Integer idBooking){
        return this.repository.existsById(idBooking);
    }
}
