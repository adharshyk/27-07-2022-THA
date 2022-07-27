package com.product.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/prod")
public class ProductController {

	@Autowired
	ProductService service;
	
	
	//List all product details
	@GetMapping("/showprod")
	public List<Product> findAll() {
		return service.findAll();
	}
	
	
	//List product details of a given product id
	@GetMapping("/product/{prodId}")
	public Product findById(@PathVariable Integer prodId) throws Exception {
		Product p = service.findById(prodId);

		if (p == null)
			throw new Exception("Emp ID : " + prodId + " not available in database.");

		return p;
	}
	
	
	//Add new product
	@PostMapping("/addProd")
	public String addEmployee(@RequestBody Product p) {
		service.saveOrUpdate(p);
		return "Product added to database";
	}
	
	
	//Update product
	@PutMapping("updateProd")
	public String updateEmployee(@RequestBody Product p) {
		service.saveOrUpdate(p);
		return "Product details updated";
	}
	
	
	//delete a product by id
	@DeleteMapping("product/{prodId}")
		public String deleteById(@PathVariable Integer prodId) {
			service.delete(prodId);
			return "Deleted Succesfully";
	}
	
	

}
