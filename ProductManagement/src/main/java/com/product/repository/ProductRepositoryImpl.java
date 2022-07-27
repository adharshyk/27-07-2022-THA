package com.product.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	EntityManager entityManager;

	public List<Product> findAll() {

		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("select p from Product p", Product.class);
		List<Product> products = query.getResultList();

		return products;
	}

	public Product findById(Integer prodId) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.get(Product.class, prodId);
	}

	@Transactional
	public void saveOrUpdate(Product p) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(p);

	}

	@Transactional
	public void delete(Integer prodId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("delete from Product where id = :productId");
		query.setParameter("productId", prodId);
		query.executeUpdate();
	}
}
