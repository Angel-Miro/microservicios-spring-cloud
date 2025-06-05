package com.msitem.services.impl;

import com.msitem.models.Item;
import com.msitem.models.Product;
import com.msitem.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Optional;
import java.util.HashMap;


@Service
@RequiredArgsConstructor
public class ItemServiceWebClient implements ItemService {

    private final WebClient.Builder webClient;


    @Override
    public List<Item> findAll() {
        return this.webClient.build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Product.class)
                .map(product -> new Item(product, new Random().nextInt(10) + 1))
                .collectList()
                .block();
    }

    @Override
    public Optional<Item> findById(Long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        try {
            return Optional.ofNullable(this.webClient.build()
                    .get()
                    .uri("/{id}", params)
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Product.class)
                    .map(product -> new Item(product, new Random().nextInt(10) + 1))
                    .block());
        }catch(WebClientResponseException e){
            return Optional.empty();
        }


    }
}
