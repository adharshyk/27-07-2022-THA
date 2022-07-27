package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository repository;

	
	public List<Product> findAll() {
		return repository.findAll();
	}


	public Product findById(Integer prodId) {
		return repository.findById(prodId);
	}


	
	public void saveOrUpdate(Product p) {
		repository.saveOrUpdate(p);
		
	}
	
	public void delete(Integer prodId) {
		repository.delete(prodId);
	}

}
