package dev.mayank.EcommerceProductService.repository;

import dev.mayank.EcommerceProductService.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{

}
