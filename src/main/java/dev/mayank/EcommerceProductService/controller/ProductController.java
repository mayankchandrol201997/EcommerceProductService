package dev.mayank.EcommerceProductService.controller;
import dev.mayank.EcommerceProductService.Entity.Product;
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
    public ResponseEntity getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProduct(@PathVariable("id") UUID id)
    {
        if(id==null)
            throw new InvalidInputException("Invalid Input");

        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping()
    public ResponseEntity createProduct(@RequestBody Product product)
    {
        Product savedProduct = productService.createProduct(product);
        return ResponseEntity.ok(savedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") UUID productId)
    {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") UUID productId,@RequestBody Product product)
    {
        Product updatedProduct = productService.updateProduct(product,productId);
        return ResponseEntity.ok(updatedProduct);
    }

    @GetMapping("/productName/{name}")
    public ResponseEntity getProductByNAme(@PathVariable("name") String productName)
    {
        if(productName==null)
            throw new InvalidInputException("Invalid Input");

        Product product = productService.getProductByName(productName);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{min}/{max}")
    public ResponseEntity getProductBetween(@PathVariable("min") double minPrice,@PathVariable("max") double maxPrice)
    {
        List<Product> product = productService.getProductBetween(minPrice,maxPrice);
        return ResponseEntity.ok(product);
    }

}
