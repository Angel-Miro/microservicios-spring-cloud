package com.msitem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Item {

    private final Product product;
    private final Integer quantity;

    public Double getTotal() {
        return this.product.getPrice() * this.quantity;
    }

}
