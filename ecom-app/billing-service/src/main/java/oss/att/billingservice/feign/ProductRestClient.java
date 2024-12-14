package oss.att.billingservice.feign;

import org.springframework.hateoas.PagedModel;
import oss.att.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    Product findProductById(@PathVariable Long id);
    @GetMapping("/api/products")
    List<Product> getAllProducts();
}
