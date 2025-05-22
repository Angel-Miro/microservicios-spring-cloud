package com.msitem.services.impl;

import com.msitem.clients.ProductFeignClient;
import com.msitem.models.Item;
import com.msitem.models.Product;
import com.msitem.services.ItemService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ProductFeignClient productFeignClient;

    @Override
    public List<Item> findAll() {
        return this.productFeignClient.listAll()
                .stream()
                .map(p -> new Item(p, new Random().nextInt(10)))
                .toList();
    }

    @Override
    public Optional<Item> findById(Long id) {
        try{
            Product product = this.productFeignClient.listById(id);
            return Optional.ofNullable(new Item(this.productFeignClient.listById(id), new Random().nextInt()));
        }catch (FeignException feignException){
            return Optional.empty();
        }
    }
}
