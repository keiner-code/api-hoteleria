package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.ClientEntity;
import com.apigestion.hoteleria.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService service;

    @Autowired
    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAll(){
        return ResponseEntity.ok(this.service.geAll());
    }

    @GetMapping("/{idClient}")
    public ResponseEntity<ClientEntity> getById(@PathVariable  Integer idClient){
        return ResponseEntity.ok(this.service.getById(idClient));
    }

    @PostMapping
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client){
        if(client.getIdClient() == null || !this.service.exists(client.getIdClient())){
            return ResponseEntity.ok(this.service.save(client));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ClientEntity> update(@RequestBody ClientEntity client){
        if(client.getIdClient() != null && this.service.exists(client.getIdClient())){
            return ResponseEntity.ok(this.service.save(client));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idClient}")
    public ResponseEntity<Void> delete(Integer idClient){
        if(this.service.exists(idClient)){
            this.service.delete(idClient);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
