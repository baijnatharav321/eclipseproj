package com.nt.main.ItemController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/allProducts")
	public List<Products> allItems() {
		return productService.getAllProducts();

	}
	@RequestMapping("/allProducts/{id}")
	public Products getProdID(@PathVariable String id) {
		return productService.getProd(id);
		
	}
 
	@RequestMapping(method = RequestMethod.POST, value="/allProducts")
	public void addProducts(@RequestBody Products products ) {
		productService.addProducts(products);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/allProducts/{id}")
	public void updateProducts(@RequestBody Products products,@PathVariable String id ) {
		productService.updateProducts(products,id);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/allProducts/{id}")
	public void deleteProducts(@PathVariable String id ) {
		 productService.deleteProducts(id);
		
	}

}
