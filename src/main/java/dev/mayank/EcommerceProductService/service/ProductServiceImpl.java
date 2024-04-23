package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;
import dev.mayank.EcommerceProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(UUID productId) throws ProductNotFoundException {
        /*
        Basic way to implement
        Product savedProduct = productRepository.findById(productId).get();
        if (savedProduct == null){
            throw new ProductNotFoundException("Product not found for "+productId);
        }
        return savedProduct;
         */

       return productRepository.findById(productId).orElseThrow(
                ()->new ProductNotFoundException("Product not found for "+productId)
        );
    }

    @Override
    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }

    @Override
    public boolean deleteProduct(UUID productId) {
         productRepository.deleteById(productId);
        return true;
    }

    @Override
    public Product updateProduct(Product updatedProduct, UUID productId) {
        Product savedProduct = getProduct(productId);
        savedProduct.setCategory(updatedProduct.getCategory());
        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setRating(updatedProduct.getRating());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct = productRepository.save(updatedProduct);
        return savedProduct;
    }

    @Override
    public Product getProductByName(String productName) {
        Product savedProduct = productRepository.findProductByTitle(productName);
        if (savedProduct == null)
            throw new ProductNotFoundException("Product not found for "+productName);

        return savedProduct;
    }

    @Override
    public List<Product> getProductBetween(double minPrice, double maxPrice) {
        List<Product> savedProducts = productRepository.findByPriceBetween(minPrice,maxPrice);
        if (savedProducts == null)
            throw new ProductNotFoundException("Product not found between "+minPrice+" & "+maxPrice);

        return savedProducts;
    }
}
