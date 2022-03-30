package fr.acensi.order.application.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductApi {
    private String id;
    private String name;
    private String description;
    private String image;
    private double price;
}
