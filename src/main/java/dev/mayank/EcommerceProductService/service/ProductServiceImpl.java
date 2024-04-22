package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;
import dev.mayank.EcommerceProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<FakeStoreProductResponseDto> getAllProducts() {
        return List.of();
    }

    @Override
    public FakeStoreProductResponseDto getProduct(int productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }

    @Override
    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }
}
