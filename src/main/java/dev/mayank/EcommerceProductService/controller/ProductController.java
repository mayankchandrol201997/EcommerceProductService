package dev.mayank.EcommerceProductService.controller;
import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;
import dev.mayank.EcommerceProductService.exception.InvalidInputException;
import dev.mayank.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    @Qualifier("productService")
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts()
    {
        List<ProductResponseDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable("id") UUID id)
    {
        if(id==null)
            throw new InvalidInputException("Invalid Input");

        ProductResponseDto productResponseDto = productService.getProduct(id);
        return ResponseEntity.ok(productResponseDto);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductRequestDto product)
    {
        ProductResponseDto productResponseDto = productService.createProduct(product);
        return ResponseEntity.ok(productResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteProduct(@PathVariable("id") UUID productId)
    {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("id") UUID productId,@RequestBody CreateProductRequestDto product)
    {
        ProductResponseDto productResponseDto = productService.updateProduct(product,productId);
        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping("/productName/{name}")
    public ResponseEntity<ProductResponseDto> getProductByNAme(@PathVariable("name") String productName)
    {
        if(productName==null)
            throw new InvalidInputException("Invalid Input");

        ProductResponseDto productResponseDto = productService.getProductByName(productName);
        return ResponseEntity.ok(productResponseDto);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity<List<ProductResponseDto>> getProductBetween(@PathVariable("min") double minPrice,@PathVariable("max") double maxPrice)
    {
        List<ProductResponseDto> productResponseDtos = productService.getProductBetween(minPrice,maxPrice);
        return ResponseEntity.ok(productResponseDtos);
    }

}
