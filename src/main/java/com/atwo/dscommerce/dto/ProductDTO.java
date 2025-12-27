package com.atwo.dscommerce.dto;

import com.atwo.dscommerce.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @NotBlank(message = "campo requerido")
    @Size(min = 3, max = 80, message = "nome deve ter entre 3 e 80 caracteres")
    private String name;

    @NotBlank
    @Size(min = 10, message = "descrição deve ter no minimo 10 caracteres")
    private String description;

    @Positive(message = "o preço deve ser positivo")
    private double price;
    
    private String imgUrl;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, double price, String imgUrl) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getimgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
