package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product addProduct(Product product) {
		Product saveProduct = productRepository.save(product);
		return saveProduct;
	}

	@Override
	public Product getProduct(Integer id) {
		Optional<Product> productOptional = productRepository.findById(id);
		return productOptional.orElse(null);
	}

	@Override
	public Product updateProduct(Product product) {
		Product productFromDb = productRepository.findById(product.getId()).orElse(null);
		if (productFromDb == null) {
			throw new RuntimeException("No such order exists");
		}
		productFromDb.setProductName(product.getProductName());
		productFromDb.setPrice(product.getPrice());

		return productRepository.save(productFromDb);

	}

	@Override
	public String deleteOrder(Integer id) {

		productRepository.deleteById(id);

		return "Deleted";
	}

}
