package oss.att.orderservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import oss.att.orderservice.model.Customer;

import java.util.List;


@FeignClient(name = "customer-service")
public interface CustomerRestClientService {
    @GetMapping("/api/customers/{id}?projection=fullCustomer")
    public Customer customerById(@PathVariable Long id);

    @GetMapping("/api/customers?projection=fullCustomer")
    public List<Customer> getAllCustomers();
}