package com.example.simplewebservice.customer;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    CustomerStore customerStore;
    public CustomerController(CustomerStore store) {
        this.customerStore = store;
    }

    // Get all customers
    @GetMapping("/")
    public List<Customer> getCustomers() {
        return customerStore.getCustomers();
    }

    // Get a customer by id
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(long id) {
        Customer customer = customerStore.getCustomer(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

    // Add a customer
    @PostMapping("/")
    public Customer addCustomer(@RequestBody Customer customer) {
        customerStore.addCustomer(customer);
        return customer;
    }

    // Update a customer
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer c = customerStore.getCustomer(customer.getId());
        if (c == null) {
            return ResponseEntity.notFound().build();
        }
        customerStore.updateCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    // Delete a customer
    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomer(long id) {
        Customer customer = customerStore.getCustomer(id);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        customerStore.deleteCustomer(id);
        return ResponseEntity.ok(customer);
    }
}
