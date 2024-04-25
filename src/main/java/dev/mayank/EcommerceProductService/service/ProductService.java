package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductResponseDto> getAllProducts();
    ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException;
    ProductResponseDto createProduct(CreateProductRequestDto product);
    boolean deleteProduct(UUID productId);
    ProductResponseDto updateProduct(CreateProductRequestDto updatedProduct,UUID productId);
    ProductResponseDto getProductByName(String productName);
    List<ProductResponseDto> getProductBetween(double minPrice, double maxPrice);
}
