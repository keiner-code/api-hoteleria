package com.apigestion.hoteleria.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "consumption")
@Getter
@Setter
@NoArgsConstructor
public class ConsumptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_consumption", nullable = false)
    private Integer idConsumer;

    @Column(name = "id_booking", nullable = false)
    private Integer idBooking;

    @Column(name = "id_service", nullable = false)
    private Integer idService;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double amount;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double price;

    @Column(nullable = false, length = 15)
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id_booking", updatable = false, insertable = false)
    @JsonIgnore
    private BookingEntity booking;

    @ManyToOne
    @JoinColumn(name = "id_service", referencedColumnName = "id_service", updatable = false, insertable = false)
    @JsonIgnore
    private ServiceEntity service;

}
