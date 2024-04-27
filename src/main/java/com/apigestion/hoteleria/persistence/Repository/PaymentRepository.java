package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.PaymentEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PaymentRepository extends ListCrudRepository<PaymentEntity, Integer> {
}
