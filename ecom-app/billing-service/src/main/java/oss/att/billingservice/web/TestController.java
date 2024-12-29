package oss.att.billingservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import oss.att.billingservice.feign.ProductRestClient;
import oss.att.billingservice.model.Product;

import java.util.List;

@RestController
public class TestController {

    private final ProductRestClient productRestClient;

    @Autowired
    public TestController(ProductRestClient productRestClient) {
        this.productRestClient = productRestClient;
    }

    @GetMapping("/test/products")
    public List<Product> testGetAllProducts() {
        return productRestClient.getAllProducts();
    }
}
