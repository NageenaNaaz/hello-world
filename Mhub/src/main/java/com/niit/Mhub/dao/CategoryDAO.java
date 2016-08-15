package com.niit.Mhub.dao;

import java.util.List;

import com.niit.Mhub.model.CategoryModel;

public interface CategoryDAO {

	public void insertCategoryModel(CategoryModel c);

	public List<CategoryModel> getCategoryList();

	public void remove(int id);

	public void update(CategoryModel a);

}
