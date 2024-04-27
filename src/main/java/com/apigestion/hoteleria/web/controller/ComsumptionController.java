package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.ClientEntity;
import com.apigestion.hoteleria.persistence.Entity.ConsumptionEntity;
import com.apigestion.hoteleria.service.ConsumptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comsumption")
public class ComsumptionController {
    private final ConsumptionService service;

    @Autowired
    public ComsumptionController(ConsumptionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ConsumptionEntity>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{idConsumer}")
    public ResponseEntity<ConsumptionEntity> getById(@PathVariable Integer idConsumer){
        return ResponseEntity.ok(this.service.getById(idConsumer));
    }

    @PostMapping
    public ResponseEntity<ConsumptionEntity> save(@RequestBody ConsumptionEntity consumption){
        if(consumption.getIdConsumer() == null || !this.service.exists(consumption.getIdConsumer())){
            return ResponseEntity.ok(this.service.save(consumption));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<ConsumptionEntity> update(@RequestBody ConsumptionEntity consumption){
        if(consumption.getIdConsumer() != null && this.service.exists(consumption.getIdConsumer())){
            return ResponseEntity.ok(this.service.save(consumption));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{idConsumer}")
    public ResponseEntity<Void> delete(Integer idConsumer){
        if(this.service.exists(idConsumer)){
            this.service.delete(idConsumer);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}
