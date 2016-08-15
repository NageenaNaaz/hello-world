package com.niit.Mhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Mhub.dao.SupplierDAO;
import com.niit.Mhub.model.SupplierModel;

@Service
public class SupplierServiceimpl implements SupplierService{

	@Autowired
	SupplierDAO supplierDAO;

	public void insertSupplierModel(SupplierModel ss) {
		// TODO Auto-generated method stub
		supplierDAO.insertSupplierModel(ss);
	}


	public List<SupplierModel> getSupplierList() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("IN SERVICE");
				List<SupplierModel> a=supplierDAO.getSupplierList();
				System.out.println(a);
				return a;
	}
	public void update(SupplierModel ss) {
		// TODO Auto-generated method stub
		supplierDAO.update(ss);
	}
	public void remove(int id) {
		// TODO Auto-generated method stub
		supplierDAO.remove(id);
	}
	
}
