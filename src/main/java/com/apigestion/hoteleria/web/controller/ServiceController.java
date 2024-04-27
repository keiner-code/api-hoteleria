package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.ServiceEntity;
import com.apigestion.hoteleria.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
    private final ServiceService service;

    @Autowired
    public ServiceController(ServiceService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ServiceEntity>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping("/{idService}")
    public ResponseEntity<ServiceEntity> getById(@PathVariable Integer idService){
        return ResponseEntity.ok(this.service.getById(idService));
    }
    @PostMapping
    public ResponseEntity<ServiceEntity> save(@RequestBody ServiceEntity service){
        System.out.println(service);
        if(service.getIdService() == null || !this.service.exists(service.getIdService())){
            return ResponseEntity.ok(this.service.save(service));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<ServiceEntity> update(@RequestBody ServiceEntity service){
        if(service.getIdService() != null  && this.service.exists(service.getIdService())){
            return ResponseEntity.ok(this.service.save(service));
        }else{
            return  ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{idService}")
    public ResponseEntity<Void> delete(@PathVariable Integer idService){
        if (service.exists(idService)){
            this.service.delete(idService);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
