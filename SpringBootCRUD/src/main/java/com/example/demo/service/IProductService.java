package com.example.demo.service;

import com.example.demo.model.Product;

public interface IProductService {

	public Product addProduct(Product product);

	Product getProduct(Integer id);

	Product updateProduct(Product product);

	String deleteOrder(Integer id);
}
