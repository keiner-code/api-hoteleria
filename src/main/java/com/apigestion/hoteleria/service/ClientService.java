package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.ClientEntity;
import com.apigestion.hoteleria.persistence.Entity.ServiceEntity;
import com.apigestion.hoteleria.persistence.Repository.ClientRepository;
import com.apigestion.hoteleria.persistence.Repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository repository;

    @Autowired
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }
    public List<ClientEntity> geAll(){
        return this.repository.findAll();
    }
    public ClientEntity getById(Integer idClient){
        return this.repository.findById(idClient).orElseThrow(()-> new RuntimeException("El Servicio no existe"));
    }
    public ClientEntity save(ClientEntity client){
        return this.repository.save(client);
    }
    public void delete(Integer idClient){
        this.repository.deleteById(idClient);
    }

    public Boolean exists(Integer idClient){
        return this.repository.existsById(idClient);
    }
}
