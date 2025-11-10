package com.shopify.virtual.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {
    private Long id;

    @Size(min = 3, max = 80, message = "Precisa ter no minimo 3 caracteres")
    @NotBlank(message = "Campo requerido")
    private String name;
    private String description;

    @Positive(message = "O preço deve ser positivo")
    private Double price;

    @Positive(message = "Não pode ser negativo")
    private Integer stock;

    @NotBlank(message = "Não pode ser vazio")
    private String category;

    public ProductDTO(Long id, String name, String description, Double price, Integer stock, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
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

    public Double getPrice() {
        return price;
    }

    public Integer getStock() {
        return stock;
    }

    public String getCategory() {
        return category;
    }
}
