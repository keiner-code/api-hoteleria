package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.ServiceEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ServiceRepository extends ListCrudRepository<ServiceEntity, Integer> {
}
