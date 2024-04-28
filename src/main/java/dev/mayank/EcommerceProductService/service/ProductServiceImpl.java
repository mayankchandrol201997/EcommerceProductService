package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Category;
import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;
import dev.mayank.EcommerceProductService.exception.CategoryNotFoundException;
import dev.mayank.EcommerceProductService.exception.NoProductsFoundException;
import dev.mayank.EcommerceProductService.exception.ProductNotFoundException;
import dev.mayank.EcommerceProductService.mapper.ProductEntityDtoMapper;
import dev.mayank.EcommerceProductService.repository.CategoryRepository;
import dev.mayank.EcommerceProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("productService")
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
        {
            throw new NoProductsFoundException("No products found");
        }
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product:products)
        {
            productResponseDtos.add(
                    ProductEntityDtoMapper.convertProductEntityToProductResponseDto(product));
        }
        return productResponseDtos;
    }

    @Override
    public ProductResponseDto getProduct(UUID productId) throws ProductNotFoundException {
        /*
        Basic way to implement
        Product savedProduct = productRepository.findById(productId).get();
        if (savedProduct == null){
            throw new ProductNotFoundException("Product not found for "+productId);
        }
        return savedProduct;
         */

       Product product = productRepository.findById(productId).orElseThrow(
                ()->new ProductNotFoundException("Product not found for "+productId)
        );

        ProductResponseDto productResponseDto =
                ProductEntityDtoMapper.convertProductEntityToProductResponseDto(product);

        return productResponseDto;

    }

    @Override
    public ProductResponseDto createProduct(CreateProductRequestDto productRequestDto) {
        Product product = ProductEntityDtoMapper.convertCreateProductRequestDtoToProduct(productRequestDto);
        Category savedCategory = categoryRepository.findById(productRequestDto.getCategoryId()).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found for category Id "+productRequestDto.getCategoryId())
        );

        product.setCategory(savedCategory);
        Product savedProduct = productRepository.save(product);
        savedCategory.getProducts().add(product);
        categoryRepository.save(savedCategory);
        return ProductEntityDtoMapper.convertProductEntityToProductResponseDto(savedProduct);
    }

    @Override
    public boolean deleteProduct(UUID productId) {
         productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductResponseDto updateProduct(CreateProductRequestDto updatedProduct, UUID productId) {
        Product savedProduct = productRepository.findById(productId).orElseThrow(
                ()->new ProductNotFoundException("Product not found for "+productId));

        savedProduct.setTitle(updatedProduct.getTitle());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct.setPrice(updatedProduct.getPrice());
        savedProduct.setDescription(updatedProduct.getDescription());
        savedProduct = productRepository.save(savedProduct);

        return ProductEntityDtoMapper.convertProductEntityToProductResponseDto(savedProduct);
    }

    @Override
    public ProductResponseDto getProductByName(String productName) {
        Product savedProduct = productRepository.findProductByTitle(productName);
        if (savedProduct == null)
            throw new ProductNotFoundException("Product not found for "+productName);

            return ProductEntityDtoMapper.convertProductEntityToProductResponseDto(savedProduct);

    }

    @Override
    public List<ProductResponseDto> getProductBetween(double minPrice, double maxPrice) {
        List<Product> savedProducts = productRepository.findByPriceBetween(minPrice,maxPrice);
        if (savedProducts == null)
            throw new ProductNotFoundException("Product not found between "+minPrice+" & "+maxPrice);

        List<ProductResponseDto> productResponseDtos = new ArrayList<>();
        for (Product product:savedProducts)
        {
            productResponseDtos.add(
                    ProductEntityDtoMapper.convertProductEntityToProductResponseDto(product));
        }
        return productResponseDtos;
    }
}
