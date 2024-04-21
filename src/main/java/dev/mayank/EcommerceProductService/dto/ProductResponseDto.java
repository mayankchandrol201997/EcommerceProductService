package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto {
    private int productId;
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
