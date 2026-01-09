package com.atwo.dscommerce.dto;

import com.atwo.dscommerce.entities.Product;

public class ProductMinDTO {

    private Long id;
    private String name;
    private double price;
    private String imgUrl;

    public ProductMinDTO() {
    }

    public ProductMinDTO(Long id, String name, String description, double price, String imgUrl) {

        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getimgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
