package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.ConsumptionEntity;
import com.apigestion.hoteleria.persistence.Repository.ComsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionService {
    private final ComsumptionRepository repository;

    @Autowired
    public ConsumptionService(ComsumptionRepository repository) {
        this.repository = repository;
    }

    public List<ConsumptionEntity> getAll(){
        return this.repository.findAll();
    }
    public ConsumptionEntity getById(Integer idConsumer){
        return this.repository.findById(idConsumer).orElseThrow(() -> new RuntimeException("El Consumo no existe"));
    }
    public ConsumptionEntity save(ConsumptionEntity consumption){
        return this.repository.save(consumption);
    }
    public void delete(Integer idConsumer){
        this.repository.deleteById(idConsumer);
    }
    public Boolean exists(Integer idConsumer){
        return this.repository.existsById(idConsumer);
    }
}
