package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.BookingEntity;
import com.apigestion.hoteleria.persistence.Entity.EmployeeEntity;
import com.apigestion.hoteleria.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {
    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<BookingEntity>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
    @GetMapping("/{idBooking}")
    public ResponseEntity<BookingEntity> getById(@PathVariable Integer idBooking){
        return ResponseEntity.ok(this.service.getByIdBooking(idBooking));
    }
    @PostMapping
    public ResponseEntity<BookingEntity> save(@RequestBody BookingEntity booking){
        System.out.println(booking);

        if(booking.getIdBooking() == null || !this.service.exists(booking.getIdBooking())){
            return ResponseEntity.ok(this.service.save(booking));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<BookingEntity> update(@RequestBody BookingEntity booking){
        if(booking.getIdBooking() != null  && this.service.exists(booking.getIdBooking())){
            return ResponseEntity.ok(this.service.save(booking));
        }else{
            return  ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{idBooking}")
    public ResponseEntity<Void> delete(@PathVariable Integer idBooking){
        if (service.exists(idBooking)){
            this.service.delete(idBooking);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
