package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.client.FakeStoreClient;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.NoProductsFoundException;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FakeStoreServiceProductServiceImpl implements ProductService{
    @Autowired
    private FakeStoreClient fakeStoreClient;

    @Override
    public List<FakeStoreProductResponseDto> getAllProducts() {
        List<FakeStoreProductResponseDto> fakeStoreProductResponseDtoList = fakeStoreClient.getAllProducts();
        if (fakeStoreProductResponseDtoList == null)
            throw new NoProductsFoundException("No products found");
        return fakeStoreProductResponseDtoList;
    }

    @Override
    public FakeStoreProductResponseDto getProduct(int productId) throws ProductNotFoundException {
         FakeStoreProductResponseDto fakeStoreProductResponseDto = fakeStoreClient.getProduct(productId);
         if (fakeStoreProductResponseDto == null)
             throw new ProductNotFoundException("Product not found with Id "+productId);

         return fakeStoreProductResponseDto;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
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
