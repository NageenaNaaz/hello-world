package com.niit.Mhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Mhub.dao.CategoryDAO;
import com.niit.Mhub.model.CategoryModel;

@Service
public class CategoryServiceimpl implements CategoryService{

	@Autowired
	CategoryDAO categoryDAO;

	public void insertCategoryModel(CategoryModel c) {
		// TODO Auto-generated method stub
		categoryDAO.insertCategoryModel(c);
	}

	public List<CategoryModel> getCategoryList() {
		// TODO Auto-generated method stub
		System.out.println("IN SERVICE");
		List <CategoryModel> a=categoryDAO.getCategoryList();
		System.out.println(a);
		return a;
	}

	public void update(CategoryModel c) {
		// TODO Auto-generated method stub
		categoryDAO.update(c);
	}

	public void remove(int id) {
		// TODO Auto-generated method stub
		categoryDAO.remove(id);
	}
	


	
}
