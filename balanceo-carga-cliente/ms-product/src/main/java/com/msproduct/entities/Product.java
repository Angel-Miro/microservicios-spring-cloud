package com.msproduct.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private LocalDateTime createdAt;

    @Transient // Esta anotación indica que no es un campo de la bd, sino de la clase misma
    private Integer port;
}
