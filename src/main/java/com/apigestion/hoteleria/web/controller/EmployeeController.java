package com.apigestion.hoteleria.web.controller;

import com.apigestion.hoteleria.persistence.Entity.EmployeeEntity;
import com.apigestion.hoteleria.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEntity>> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/{document}")
    public ResponseEntity<EmployeeEntity> getByDocument(@PathVariable String document){
        return ResponseEntity.ok(this.service.getByDocument(document));
    }
    @PostMapping
    public ResponseEntity<EmployeeEntity> save(@RequestBody EmployeeEntity employee){
        System.out.println(employee);
        if(employee.getIdEmployee() == null || !this.service.exists(employee.getIdEmployee())){
            return ResponseEntity.ok(this.service.save(employee));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<EmployeeEntity> update(@RequestBody EmployeeEntity employee){
        if(employee.getIdEmployee() != null  && this.service.exists(employee.getIdEmployee())){
            return ResponseEntity.ok(this.service.save(employee));
        }else{
            return  ResponseEntity.badRequest().build();
        }
    }
    @DeleteMapping("/{idEmployee}")
    public ResponseEntity<Void> delete(@PathVariable Integer idEmployee){
        if (service.exists(idEmployee)){
            this.service.delete(idEmployee);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }
}
