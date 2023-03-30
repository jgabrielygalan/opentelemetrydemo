package com.oteldemo.product.api;

import com.oteldemo.product.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GetProductController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/product/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        String category = getCategoryForName(name);
        return ResponseEntity.ok(new Product(name, category));
    }

    private String getCategoryForName(String name) {
        switch(name) {
            case "milk":
                return("beverages");
            case "fruit":
            case "bread":
                return("food");
            default:
                return("other");
        }
    }
}
