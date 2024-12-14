package oss.att.orderservice.services;

import oss.att.orderservice.model.Customer;
import oss.att.orderservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping("/api/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);

    @GetMapping("/api/products?projection=fullProduct")
    public List<Product> getAllProducts();
}
