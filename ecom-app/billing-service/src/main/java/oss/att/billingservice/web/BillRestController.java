package oss.att.billingservice.web;

import oss.att.billingservice.entities.Bill;
import oss.att.billingservice.exceptions.ResourceNotFoundException;
import oss.att.billingservice.feign.CustomerRestClient;
import oss.att.billingservice.feign.ProductRestClient;
import oss.att.billingservice.repository.BillRepository;
import oss.att.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;


    @GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id) {
        return billRepository.findById(id)
                .map(bill -> {
                    bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
                    bill.getProductItems().forEach(productItem -> {
                        productItem.setProduct(productRestClient.findProductById(productItem.getProductId()));
                    });
                    return bill;
                })
                .orElseThrow(() -> new ResourceNotFoundException("Bill not found with id: " + id));
    }


    @GetMapping("/bills")
    public List<Bill> getAllBills(){
        return billRepository.findAll();
    }
}
