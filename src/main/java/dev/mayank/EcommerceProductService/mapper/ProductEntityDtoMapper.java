package dev.mayank.EcommerceProductService.mapper;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;

public class ProductEntityDtoMapper {

    public static ProductResponseDto convertProductEntityToProductResponseDto(Product product)
    {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setProductId(product.getId());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setTitle(product.getTitle());
        productResponseDto.setPrice(product.getPrice());
        productResponseDto.setImageUrl(product.getImageUrl());
        productResponseDto.setRating(product.getRating());
        if(product.getCategory()!=null)
        productResponseDto.setCategory(product.getCategory().getName());
        return productResponseDto;
    }

    public static Product convertCreateProductRequestDtoToProduct(CreateProductRequestDto createProductRequestDto)
    {
        Product product = new Product();
        product.setTitle(createProductRequestDto.getTitle());
        product.setDescription(createProductRequestDto.getDescription());
        product.setPrice(createProductRequestDto.getPrice());
        product.setImageUrl(createProductRequestDto.getImageUrl());
        product.setRating(0);
        return product;
    }
}
