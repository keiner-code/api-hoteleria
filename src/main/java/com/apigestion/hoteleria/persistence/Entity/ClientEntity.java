package com.apigestion.hoteleria.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    private Integer idClient;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(name="last_name",nullable = false, length = 20)
    private String lastName;

    @Column(name="type_document",nullable = false, length = 15)
    private String typeDocument;

    @Column(nullable = false, length = 10)
    private String document;

    @Column(length = 100)
    private String address;

    @Column(nullable = false, length = 10)
    private String phone;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(name = "code_client", nullable = false, length = 12)
    private String codeClient;

    @OneToMany(mappedBy = "client")
    private List<BookingEntity> bookings;

}
