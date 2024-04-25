package dev.mayank.EcommerceProductService.mapper;

import dev.mayank.EcommerceProductService.Entity.Category;
import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.CategoryResponseDto;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryEntityDtoMapper {

    public static CategoryResponseDto convertCategoryEntityToCategoryResponseDto(Category category)
    {
        CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
        categoryResponseDto.setCategoryId(category.getId());
        categoryResponseDto.setCategoryName(category.getName());
        if (category.getProducts()!=null)
        {
            List<ProductResponseDto> productResponseDtos = new ArrayList<>();
            for(Product product:category.getProducts())
            {
                ProductResponseDto productResponseDto =
                        ProductEntityDtoMapper.convertProductEntityToProductResponseDto(product);
                productResponseDtos.add(productResponseDto);
            }
            categoryResponseDto.setProduct(productResponseDtos);
        }
        return categoryResponseDto;
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
