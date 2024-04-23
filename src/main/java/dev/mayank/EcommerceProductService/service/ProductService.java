package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(UUID productId) throws ProductNotFoundException;
    Product createProduct(Product product);
    boolean deleteProduct(UUID productId);
    Product updateProduct(Product updatedProduct,UUID productId);
    Product getProductByName(String productName);
    List<Product> getProductBetween(double minPrice, double maxPrice);
}
