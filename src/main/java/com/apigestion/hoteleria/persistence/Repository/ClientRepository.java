package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.ClientEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientRepository extends ListCrudRepository<ClientEntity, Integer> {
}
