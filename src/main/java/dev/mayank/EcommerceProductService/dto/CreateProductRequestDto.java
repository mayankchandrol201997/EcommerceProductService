package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateProductRequestDto {
    private String title;
    private double price;
    private String description;
    private UUID categoryId;
    private String imageUrl;
}
