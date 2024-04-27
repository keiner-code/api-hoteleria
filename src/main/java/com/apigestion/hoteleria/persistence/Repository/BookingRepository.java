package com.apigestion.hoteleria.persistence.Repository;

import com.apigestion.hoteleria.persistence.Entity.BookingEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface BookingRepository extends ListCrudRepository<BookingEntity, Integer> {
}
