package com.apigestion.hoteleria.persistence.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "service")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_service", nullable = false)
    private Integer idService;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double amount;

    @Column(nullable = false, length = 45)
    private String description;

    @Column(nullable = false, length = 45)
    private String characters;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double price;

    @Column(nullable = false, length = 15)
    private String state;

    @OneToMany(mappedBy = "service")
    private List<ConsumptionEntity> consumptions;

}
