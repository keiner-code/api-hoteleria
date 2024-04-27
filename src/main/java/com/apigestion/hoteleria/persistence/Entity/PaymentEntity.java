package com.apigestion.hoteleria.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "payment")
@Getter
@Setter
@NoArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment", nullable = false)
    private Integer idPayment;

    @Column(name = "id_booking", nullable = false)
    private Integer idBooking;

    @Column(name = "voucher_type", nullable = false, length = 20)
    private String voucherType;

    @Column(name = "voucher_number", nullable = false, length = 20)
    private String voucherNumber;

    @Column(nullable = false, columnDefinition = "DECIMAL(7,2)")
    private Double iva;

    @Column(name = "broadcast_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime broadCastDate;

    @Column(name = "payment_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime paymentDate;

    @OneToOne
    @JoinColumn(name = "id_booking", referencedColumnName = "id_booking", insertable = false, updatable = false)
    @JsonIgnore
    private BookingEntity booking;

}
