package com.msitem.clients;

import com.msitem.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-product", path = "/products")
public interface ProductFeignClient {

    @GetMapping
    List<Product> listAll();

    @GetMapping("/{id}")
    Product listById(@PathVariable Long id);


}
