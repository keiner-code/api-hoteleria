package com.apigestion.hoteleria.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class BookingEntity {
    @Id
    @Column(name = "id_booking", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooking;

    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Column(name = "type_booking",nullable = false, length = 45)
    private String typeBooking;

    @Column(name = "reservation_date",nullable = false, length = 45)
    private String reservationDate;

    @Column(name = "admission_date",nullable = false, length = 45)
    private String admissionDate;

    @Column(name = "departure_date",nullable = false, length = 45)
    private String departureDate;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private String price;

    @Column(nullable = false, length = 15)
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_employee", referencedColumnName = "id_employee", insertable = false, updatable = false)
    @JsonIgnore
    private EmployeeEntity employee;

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", insertable = false, updatable = false)
    @JsonIgnore
    private ClientEntity client;

    @OneToMany(mappedBy = "booking")
    @JsonIgnore
    private List<ConsumptionEntity> consumptions;
}
