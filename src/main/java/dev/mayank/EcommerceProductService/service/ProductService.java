package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<FakeStoreProductResponseDto> getAllProducts();
    FakeStoreProductResponseDto getProduct(int productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    boolean deleteProduct(int productId);
    Product updateProduct(Product updatedProduct,int productId);
}
