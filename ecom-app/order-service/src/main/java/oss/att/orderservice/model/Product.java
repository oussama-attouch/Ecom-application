package oss.att.orderservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter
@Setter
public class Product {
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
