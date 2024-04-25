package dev.mayank.EcommerceProductService.repository;

import dev.mayank.EcommerceProductService.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findCategoryByName(String name);
}
