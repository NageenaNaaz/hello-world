package com.niit.Mhub.service;

import java.util.List;

import com.niit.Mhub.model.ProductModel;

public interface ProductService {

	public void insertProductModel(ProductModel pp);

	public List<ProductModel> getProductList();
	public void update(ProductModel pp);

	public void remove(int id);
}
