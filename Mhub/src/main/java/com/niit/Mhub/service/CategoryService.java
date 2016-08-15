package com.niit.Mhub.service;

import java.util.List;

import com.niit.Mhub.model.CategoryModel;

public interface CategoryService {

	public void insertCategoryModel(CategoryModel c);

	public List<CategoryModel> getCategoryList();

	public void update(CategoryModel a);

	public void remove(int id);
}
