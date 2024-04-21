package dev.mayank.EcommerceProductService.controller;

import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.FakeStoreProductResponseDto;
import dev.mayank.EcommerceProductService.exception.InvalidInputException;
import dev.mayank.EcommerceProductService.mapper.ProductEntityDtoMapper;
import dev.mayank.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity getAllProducts()
    {
        List<FakeStoreProductResponseDto> products = productService.getAllProducts();
        //ProductEntityDtoMapper.convertProductEntityToProductResponseDto(pr)
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") int id)
    {
        if(id<1)
            throw new InvalidInputException("Invalid Input");

        FakeStoreProductResponseDto product = productService.getProduct(id);
        //ProductEntityDtoMapper.convertProductEntityToProductResponseDto(pr)
        return ResponseEntity.ok(product);
    }
}