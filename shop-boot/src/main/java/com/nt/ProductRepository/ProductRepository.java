package com.nt.ProductRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.main.ItemController.Products;

public interface ProductRepository extends JpaRepository<Products, String> {

}
