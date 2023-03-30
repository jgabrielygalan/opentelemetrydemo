package com.oteldemo.api.api;

import com.oteldemo.api.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GetProductsController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${productClient.baseUrl}")
    private String baseUrl;

    @GetMapping(value="/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getProducts() {
        List<String> names = List.of("milk", "fruit", "bread");
        List<Product> products = new ArrayList<>();
        for (String name: names) {
            String url = String.format("%s/product/%s", baseUrl, name);
            ResponseEntity<Product> product = restTemplate.getForEntity(url, Product.class);
            products.add(product.getBody());
        }
        return ResponseEntity.ok(products);
    }
}
