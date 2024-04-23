package dev.mayank.EcommerceProductService.mapper;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;

public class ProductEntityDtoMapper {

    public static ProductResponseDto convertProductEntityToProductResponseDto(Product product)
    {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        //productResponseDto.setProductId(product.getId());
        //productResponseDto.setDescription(product.getCategory());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setRating(product.getRating());
        return productResponseDto;
    }
}
