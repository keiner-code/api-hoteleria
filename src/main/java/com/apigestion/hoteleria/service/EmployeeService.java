package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.EmployeeEntity;
import com.apigestion.hoteleria.persistence.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
    public List<EmployeeEntity> getAll(){
        return this.repository.findAll();
    }
    public EmployeeEntity getByDocument(String document){
        return this.repository.findByDocument(document).orElseThrow(() -> new RuntimeException("El Empleado no existe"));
    }
    public EmployeeEntity save(EmployeeEntity employee){
        return this.repository.save(employee);
    }
    public void delete(Integer idEmployee){
        this.repository.deleteById(idEmployee);
    }
    public Boolean exists(Integer idEmployee){
        return this.repository.existsById(idEmployee);
    }
}
