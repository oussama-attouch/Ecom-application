package oss.att.billingservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import oss.att.billingservice.entities.Bill;
import oss.att.billingservice.entities.ProductItem;
import oss.att.billingservice.feign.CustomerRestClient;
import oss.att.billingservice.feign.ProductRestClient;
import oss.att.billingservice.model.Customer;
import oss.att.billingservice.model.Product;
import oss.att.billingservice.repository.BillRepository;
import oss.att.billingservice.repository.ProductItemRepository;

import java.util.*;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient){
        return args -> {
            List<Customer> customers = customerRestClient.getAllCustomers();
           // List<Product> products = productRestClient.getAllProducts();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);
            /*products.forEach(product -> {
                ProductItem productItem = ProductItem.builder()
                        .bill(bill)
                        .productId(product.getId())
                        .quantity(1+new Random().nextInt(10))
                        .price(product.getPrice())
                        .build();
                productItemRepository.save(productItem);
            });*/
            });
        };
    }

}
