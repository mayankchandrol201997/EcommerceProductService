package dev.mayank.EcommerceProductService.controller;
import dev.mayank.EcommerceProductService.dto.CategoryRequestDto;
import dev.mayank.EcommerceProductService.dto.CategoryResponseDto;
import dev.mayank.EcommerceProductService.dto.CreateProductRequestDto;
import dev.mayank.EcommerceProductService.dto.ProductResponseDto;
import dev.mayank.EcommerceProductService.exception.InvalidCategoryInputException;
import dev.mayank.EcommerceProductService.exception.InvalidInputException;
import dev.mayank.EcommerceProductService.service.CategoryService;
import dev.mayank.EcommerceProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    @Qualifier("categoryService")
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDto>> getAllCategory()
    {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable("id") UUID id)
    {
        return ResponseEntity.ok(categoryService.getCategory(id));
    }

    @PostMapping()
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CategoryRequestDto categoryRequestDto)
    {
        if (categoryRequestDto.getName().isBlank()||categoryRequestDto.getName().isEmpty())
            throw new InvalidCategoryInputException("Invalid input request");

        CategoryResponseDto categoryResponseDto = categoryService.createCategory(categoryRequestDto);
        return ResponseEntity.ok(categoryResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable("id") UUID categoryId)
    {
        return ResponseEntity.ok(categoryService.deleteCategory(categoryId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable("id") UUID categoryId,@RequestBody CategoryRequestDto categoryRequestDto)
    {
        return ResponseEntity.ok(categoryService.updateCategory(categoryRequestDto,categoryId));
    }

    @GetMapping("/categotyName/{name}")
    public ResponseEntity<CategoryResponseDto> getCategoryByNAme(@PathVariable("name") String categoryName)
    {
        return ResponseEntity.ok(categoryService.getCategoryByName(categoryName));
    }

}
