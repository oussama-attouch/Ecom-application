package oss.att.inventoryservice.controller;

import oss.att.inventoryservice.entities.Product;
import oss.att.inventoryservice.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Corrected method
    @GetMapping("/{id}") // Fixed the mapping path
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productRepository.findById(id); // Changed List<Product> to Optional<Product>
    }
}
