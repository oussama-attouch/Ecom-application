package oss.att.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oss.att.customerservice.entities.Customer;
import oss.att.customerservice.entities.CustomerProjection;
import oss.att.customerservice.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("{id}")
    public Optional<Customer> getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    @GetMapping("fullCustomer")
    public List<CustomerProjection> getAllCustomers() {
        return customerRepository.findAllProjectedBy();
    }
}