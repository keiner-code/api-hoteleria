package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.EmployeeEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends ListCrudRepository<EmployeeEntity, Integer> {
    Optional<EmployeeEntity> findByDocument(String document);
}
