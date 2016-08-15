package com.niit.Mhub.dao;

import java.util.List;

import com.niit.Mhub.model.ProductModel;

public interface ProductDAO {

	public void insertProductModel(ProductModel pp);

	public List<ProductModel> getProductList();
	public void update(ProductModel pp);

	public void remove(int id);

}
