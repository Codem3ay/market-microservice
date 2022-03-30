package fr.acensi.order.application.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog")
public interface ProductFeign {

    @GetMapping("/products/{productId}")
    public ProductApi getProductById(@PathVariable Long productId);

}
