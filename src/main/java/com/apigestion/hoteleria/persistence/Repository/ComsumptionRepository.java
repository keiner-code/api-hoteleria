package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.ConsumptionEntity;
import org.hibernate.mapping.Collection;
import org.springframework.data.repository.ListCrudRepository;

public interface ComsumptionRepository extends ListCrudRepository<ConsumptionEntity, Integer> {
}
