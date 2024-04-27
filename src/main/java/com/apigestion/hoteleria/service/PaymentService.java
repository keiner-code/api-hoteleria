package com.apigestion.hoteleria.service;

import com.apigestion.hoteleria.persistence.Entity.PaymentEntity;
import com.apigestion.hoteleria.persistence.Entity.ServiceEntity;
import com.apigestion.hoteleria.persistence.Repository.PaymentRepository;
import com.apigestion.hoteleria.persistence.Repository.ServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }
    public List<PaymentEntity> getAll(){
        return this.repository.findAll();
    }
    public PaymentEntity getById(Integer idPayment){
        return this.repository.findById(idPayment).orElseThrow(() -> new RuntimeException("El Pago no existe"));
    }
    public PaymentEntity save(PaymentEntity payment){
        return this.repository.save(payment);
    }

    public void delete(Integer idPayment){
        this.repository.deleteById(idPayment);
    }

    public Boolean exists(Integer idPayment){
        return this.repository.existsById(idPayment);
    }
}
