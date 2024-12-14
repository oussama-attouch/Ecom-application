package oss.att.inventoryservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;


@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Builder
@Getter @Setter @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use AUTO for UUID
    private Long id;
    private String name;
    private double price;
    private int quantity;
}
