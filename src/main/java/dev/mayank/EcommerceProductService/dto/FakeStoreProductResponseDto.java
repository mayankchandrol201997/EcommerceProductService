package dev.mayank.EcommerceProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductResponseDto {
    private int id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;
    private FakeStoreProductRatingDto rating;

}
