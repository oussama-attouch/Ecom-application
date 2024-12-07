package oss.att.billingservice.feign;

import oss.att.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/{id}")
    Product getProductById(@PathVariable String id);
    @GetMapping
    List<Product> getAllProducts();
}
