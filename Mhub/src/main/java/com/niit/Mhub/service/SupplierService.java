package com.niit.Mhub.service;

import java.util.List;

import com.niit.Mhub.model.SupplierModel;

public interface SupplierService {

   	public void insertSupplierModel(SupplierModel ss);

	public List<SupplierModel> getSupplierList();

	public void update(SupplierModel s);

	public void remove(int id);

}
