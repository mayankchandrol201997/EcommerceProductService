package dev.mayank.EcommerceProductService.dto;

import dev.mayank.EcommerceProductService.Entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDto {
    private UUID productId;
    private String title;
    private String category;
    private String description;
    private String imageUrl;
    private double price;
    private double rating;

    /*
    id:1,
                    title:'...',
                    price:'...',
                    category:'...',
                    description:'...',
                    image:'...'
     */
}
