package com.msitem.controller;


import com.msitem.models.Item;
import com.msitem.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController

public class ItemController {

    private final ItemService itemService;

    /*
    Recordemos que Lombok no toma la anotacion @Qualifier por lo que sera necesario escribir el constructor
    El nombre del bean es igual que el de la clase pero con la primera letra en minuscula
     */
    public ItemController(@Qualifier("itemServiceWebClient") ItemService itemService){
        this.itemService = itemService;
    }


    @GetMapping
    public List<Item> listAll() {
        return this.itemService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> listAll(@PathVariable Long id) {
        Optional<Item> optionalItem = this.itemService.findById(id);
        if (optionalItem.isPresent()) {
            return ResponseEntity.ok(this.itemService.findById(id).orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap("message", "No existe el valor buscado en ms-products"));
    }

}
