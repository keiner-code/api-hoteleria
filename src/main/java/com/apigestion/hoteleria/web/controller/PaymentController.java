package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.PaymentEntity;
import com.apigestion.hoteleria.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping("/{idPayment}")
    public ResponseEntity<PaymentEntity> getById(@PathVariable Integer idPayment){
        return ResponseEntity.ok(this.service.getById(idPayment));
    }
    @PostMapping
    public ResponseEntity<PaymentEntity> save(@RequestBody PaymentEntity payment){
        if(payment.getIdPayment() == null || !this.service.exists(payment.getIdPayment())){
            return ResponseEntity.ok(this.service.save(payment));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<PaymentEntity> update(@RequestBody PaymentEntity payment){
        if(payment.getIdPayment() != null  && this.service.exists(payment.getIdPayment())){
            return ResponseEntity.ok(this.service.save(payment));
        }else{
            return  ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{idPayment}")
    public ResponseEntity<Void> delete(@PathVariable Integer idPayment){
        if (service.exists(idPayment)){
            this.service.delete(idPayment);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
