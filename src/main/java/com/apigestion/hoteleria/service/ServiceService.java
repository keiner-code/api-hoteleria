package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.ServiceEntity;
import com.apigestion.hoteleria.persistence.Repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {
    private final ServiceRepository repository;

    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }
    public List<ServiceEntity> getAll(){
        return this.repository.findAll();
    }
    public ServiceEntity getById(Integer idService){
        return this.repository.findById(idService).orElseThrow(() -> new RuntimeException("El Pago no existe"));
    }
    public ServiceEntity save(ServiceEntity service){
        return this.repository.save(service);
    }
    public void delete(Integer idService){
        this.repository.deleteById(idService);
    }
    public Boolean exists(Integer idService){
        return this.repository.existsById(idService);
    }
}
