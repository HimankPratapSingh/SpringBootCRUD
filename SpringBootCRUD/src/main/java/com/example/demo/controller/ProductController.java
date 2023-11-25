package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.IProductService;

@RestController
@RequestMapping(path = "products")
public class ProductController {

	@Autowired
	private IProductService productService;

	@PostMapping
	public Product addproduct(@RequestBody Product product) {
		return productService.addProduct(product);

	}

	@GetMapping(path = "/{id}")
	public Product getProduct(@PathVariable Integer id) {
		return productService.getProduct(id);
	}

	@PutMapping
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);

	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteProduct(@PathVariable Integer id) {
		return productService.deleteOrder(id);
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}


}
