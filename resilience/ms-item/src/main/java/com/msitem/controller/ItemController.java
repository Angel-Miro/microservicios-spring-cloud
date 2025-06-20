package com.msitem.controller;


import com.msitem.models.Item;
import com.msitem.models.Product;
import com.msitem.services.ItemService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
public class ItemController {

    private final ItemService itemService;
    private final CircuitBreakerFactory circuitBreakerFactory;

    /*
    Recordemos que Lombok no toma la anotacion @Qualifier por lo que sera necesario escribir el constructor
    El nombre del bean es igual que el de la clase pero con la primera letra en minuscula
     */
    public ItemController(@Qualifier("itemServiceWebClient") ItemService itemService,
                          CircuitBreakerFactory circuitBreakerFactory) {
        this.itemService = itemService;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }


    @GetMapping
    public List<Item> listAll() {
        return this.itemService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Item> itemOptional = circuitBreakerFactory.create("items").run(() -> itemService.findById(id), e -> {
            Product product = new Product();
            product.setCreatedAt(LocalDateTime.now());
            product.setId(1L);
            product.setName("Camara Sony");
            product.setPrice(500.00);
            return Optional.of(new Item(product, 5));
        });

        if (itemOptional.isPresent()) {
            return ResponseEntity.ok(itemOptional.get());
        }

        return ResponseEntity.status(404)
                .body(Collections.singletonMap(
                        "message",
                        "No existe el producto en el microservicio msvc-products"));
    }

}
