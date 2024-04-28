package dev.mayank.EcommerceProductService.service;

import dev.mayank.EcommerceProductService.Entity.Category;
import dev.mayank.EcommerceProductService.Entity.Product;
import dev.mayank.EcommerceProductService.exception.CategoryNotFoundException;
import dev.mayank.EcommerceProductService.repository.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CategoryServiceImplTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPriceForMultipleProductUnderCategory()
    {
        //Arrange
        UUID catgoryId = UUID.randomUUID();
        //Optional<Category> category = getCategoryMockData();
        Mockito.when(categoryRepository.findById(catgoryId)).thenReturn(getCategoryMockData());
        double expectedCost = 300.00;

        //Act
        double actualTotalCost = categoryService.getTotalPriceOfProduct(catgoryId);

        //Assert
        Assertions.assertEquals(actualTotalCost,expectedCost);
        Mockito.verify(categoryRepository).findById(catgoryId);
    }

    @Test
    public void testGetTotalPriceForZeroProductUnderCategory()
    {
        //Arrange
        UUID catgoryId = UUID.randomUUID();
        //Optional<Category> category = getCategoryMockData();
        Mockito.when(categoryRepository.findById(catgoryId)).thenReturn(getCategoryMockDataForZeroProduct());
        double expectedCost = 0.00;

        //Act
        double actualTotalCost = categoryService.getTotalPriceOfProduct(catgoryId);

        //Assert
        Assertions.assertEquals(actualTotalCost,expectedCost);
        Mockito.verify(categoryRepository).findById(catgoryId);
    }

    @Test
    public void testGetTotalPriceThrowInvalidCategoryNotFound()
    {
        //Arrange
        UUID catgoryId = UUID.randomUUID();
        //Optional<Category> category = getCategoryMockData();
        Mockito.when(categoryRepository.findById(catgoryId)).thenReturn(Optional.empty());


        //Assert
        Assertions.assertThrows(CategoryNotFoundException.class,()->categoryService.getTotalPriceOfProduct(catgoryId));
        Mockito.verify(categoryRepository).findById(catgoryId);
    }

    private Optional<Category> getCategoryMockData()
    {
        Category category = new Category();
        category.setName("CategoryName");
        category.setId(UUID.randomUUID());

        Product product1 = new Product();
        product1.setCategory(category);
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setPrice(200);

        Product product2 = new Product();
        product2.setCategory(category);
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product1");
        product2.setPrice(100);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        category.setProducts(products);
        return Optional.of(category);
    }

    private Optional<Category> getCategoryMockDataForZeroProduct()
    {
        Category category = new Category();
        category.setName("CategoryName");
        category.setId(UUID.randomUUID());

        List<Product> products = new ArrayList<>();

        category.setProducts(products);
        return Optional.of(category);
    }
}
