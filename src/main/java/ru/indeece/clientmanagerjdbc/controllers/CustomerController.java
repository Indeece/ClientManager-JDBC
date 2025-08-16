package ru.indeece.clientmanagerjdbc.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.indeece.clientmanagerjdbc.dao.CustomerDao;
import ru.indeece.clientmanagerjdbc.model.Customer;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    private final CustomerDao customerDao;

    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @PostMapping("/create")
    public ResponseEntity<Long> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerDao.create(customer));
    }

    @PostMapping("/update")
    public ResponseEntity<Integer> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerDao.update(customer));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Integer> deleteCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerDao.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerDao.findById(id));
    }
}
