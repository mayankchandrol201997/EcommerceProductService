package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.client.FakeStoreClient;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.NoProductsFoundException;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreServiceProductServiceImpl{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    public List<FakeStoreProductResponseDto> getAllProducts() {
        List<FakeStoreProductResponseDto> fakeStoreProductResponseDtoList = fakeStoreClient.getAllProducts();
        if (fakeStoreProductResponseDtoList == null)
            throw new NoProductsFoundException("No products found");
        return fakeStoreProductResponseDtoList;
    }

    public FakeStoreProductResponseDto getProduct(int productId) throws ProductNotFoundException {
         FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreClient.getProduct(productId);
         if (fakeStoreProductResponseDto == null)
             throw new ProductNotFoundException("Product not found with Id "+productId);

         return fakeStoreProductResponseDto;
    }

    public Product createProduct(Product product) {
        return null;
    }

    public boolean deleteProduct(int productId) {
        return false;
    }

    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }
}
