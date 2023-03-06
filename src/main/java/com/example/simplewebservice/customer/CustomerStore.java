package com.example.simplewebservice.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CustomerStore {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Customer getCustomer(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void updateCustomer(Customer customer) {
        for (Customer c : customers) {
            if (c.getId() == customer.getId()) {
                c.setName(customer.getName());
            }
        }
    }

    public void deleteCustomer(long id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                break;
            }
        }
    }
}
