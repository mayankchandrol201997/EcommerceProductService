package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Category;
import dev.mayank.EcommerceProductService.dto.CategoryRequestDto;
import dev.mayank.EcommerceProductService.dto.CategoryResponseDto;
import dev.mayank.EcommerceProductService.exception.CategoryNotFoundException;
import dev.mayank.EcommerceProductService.exception.InvalidInputException;
import dev.mayank.EcommerceProductService.exception.NoCategoryFoundException;
import dev.mayank.EcommerceProductService.mapper.CategoryEntityDtoMapper;
import dev.mayank.EcommerceProductService.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponseDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty())
            throw new NoCategoryFoundException("No category found");
        List<CategoryResponseDto> categoryResponseDtos = new ArrayList<>();

        for (Category category:categories)
        {
            categoryResponseDtos.add(
                    CategoryEntityDtoMapper.convertCategoryEntityToCategoryResponseDto(category));
        }
        return categoryResponseDtos;
    }

    @Override
    public CategoryResponseDto getCategory(UUID categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found with category id " + categoryId)
        );
        return CategoryEntityDtoMapper.convertCategoryEntityToCategoryResponseDto(category);
    }

    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category = new Category();
        category.setName(categoryRequestDto.getName());
        Category savedCategory = categoryRepository.save(category);
        return CategoryEntityDtoMapper.convertCategoryEntityToCategoryResponseDto(savedCategory);
    }

    @Override
    public boolean deleteCategory(UUID categoryId) {
        categoryRepository.deleteById(categoryId);
        return true;
    }


    @Override
    public CategoryResponseDto updateCategory(CategoryRequestDto categoryRequestDto, UUID categoryId) {
        Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(
                ()-> new NoCategoryFoundException("Category not found with category id " + categoryId)
        );

        savedCategory.setName(categoryRequestDto.getName());
        savedCategory = categoryRepository.save(savedCategory);
        return CategoryEntityDtoMapper.convertCategoryEntityToCategoryResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto getCategoryByName(String categoryName) {
        Category category = categoryRepository.findCategoryByName(categoryName);
        if (category==null)
            throw new NoCategoryFoundException("Category not found with category name " + categoryName);

        return CategoryEntityDtoMapper.convertCategoryEntityToCategoryResponseDto(category);
    }
}
