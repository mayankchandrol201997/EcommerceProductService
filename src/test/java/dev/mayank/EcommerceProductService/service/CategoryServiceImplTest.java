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
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetTotalPriceOfMultipleProductInCategory()
    {
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(mockForMultipleProductInCategory());
        double expectedAmount = 300.00;

        //Act
        double actualAmount = categoryService.getTotalPriceOfProductInCategory(categoryId);

        //Assert
        Assertions.assertEquals(expectedAmount,actualAmount);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testGetTotalPriceOfZeroProductInCategory()
    {
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(mockForZeroProductInCategory());
        double expectedAmount = 0.00;

        //Act
        double actualAmount = categoryService.getTotalPriceOfProductInCategory(categoryId);

        //Assert
        Assertions.assertEquals(expectedAmount,actualAmount);
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    @Test
    public void testGetTotalPriceForThrowInvalidCategory()
    {
        //Arrange
        UUID categoryId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        //Act and Assert
        Assertions.assertThrows(CategoryNotFoundException.class,
                ()->categoryService.getTotalPriceOfProductInCategory(categoryId));
        Mockito.verify(categoryRepository).findById(categoryId);
    }

    public Optional<Category> mockForMultipleProductInCategory()
    {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CATEGORY");

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setTitle("Product1");
        product1.setDescription("Product1 description");
        product1.setPrice(200);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setTitle("Product1");
        product2.setDescription("Product1 description");
        product2.setPrice(100);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);

        category.setProducts(products);

        return Optional.of(category);
    }

    public Optional<Category> mockForZeroProductInCategory()
    {
        Category category = new Category();
        category.setId(UUID.randomUUID());
        category.setName("CATEGORY");

        List<Product> products = new ArrayList<>();
        category.setProducts(products);

        return Optional.of(category);
    }
}
