package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.dto.CategoryRequestDto;
import dev.mayank.EcommerceProductService.dto.CategoryResponseDto;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryResponseDto> getAllCategory();
    CategoryResponseDto getCategory(UUID categoryId);
    CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto);
    boolean deleteCategory(UUID categoryId);
    CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, UUID categoryId);
    CategoryResponseDto getCategoryByName(String categoryName);

}
