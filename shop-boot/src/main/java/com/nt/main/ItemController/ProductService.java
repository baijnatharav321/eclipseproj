package com.nt.main.ItemController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.TomcatPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.ProductRepository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	private List<Products> products=new ArrayList<Products>(Arrays.asList(
			new Products("1","Mobile","Latest one"),
			new Products("2","Groceries","Fresh products"),
			new Products("3","Cloths","Good quality")
			));
 
	public List<Products> getAllProducts(){
		//return products;
		List<Products> products =new ArrayList<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}
	
	public Products getProd(String id) {
		return products.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		
	}

	public void addProducts(Products products2) {
		products.add(products2);
		
	}

	public void updateProducts(Products products2, String id) {
		for(int i=0;i<products.size();i++) {
			Products p=products.get(i);
			if(p.getId().equals(id)) {
				products.set(i, products2);
				return;
			}
		}
		
	}

	public void deleteProducts(String id) {
		products.removeIf(t -> t.getId().equals(id));
	}


	
}
