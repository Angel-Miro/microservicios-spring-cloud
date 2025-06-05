package com.msitem.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Product {

    private Long id;
    private String name;
    private Double price;
    private LocalDateTime createdAt;
    private Integer port;
}
