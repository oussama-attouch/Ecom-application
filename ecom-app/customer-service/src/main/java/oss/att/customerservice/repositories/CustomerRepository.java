package oss.att.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.PagedModel;
import oss.att.customerservice.entities.Customer;
import oss.att.customerservice.entities.CustomerProjection;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<CustomerProjection> findAllProjectedBy();
}