package com.apigestion.hoteleria.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_employee", nullable = false)
    private Integer idEmployee;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

    @Column(name = "document_type", nullable = false, length = 15)
    private String documentType;

    @Column(nullable = false, length = 10)
    private String document;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double salary;

    @OneToMany(mappedBy = "employee")
    private List<BookingEntity> bookings;


}
