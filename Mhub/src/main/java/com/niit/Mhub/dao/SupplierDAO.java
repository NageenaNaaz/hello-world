package com.niit.Mhub.dao;

import java.util.List;

import com.niit.Mhub.model.SupplierModel;

public interface SupplierDAO{

	public void insertSupplierModel(SupplierModel ss);

	public List<SupplierModel> getSupplierList();

	public void update(SupplierModel ss);

	public void remove(int id);

}
