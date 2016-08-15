package com.niit.Mhub.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Mhub.model.CategoryModel;
import com.niit.Mhub.model.ProductModel;
import com.niit.Mhub.model.SupplierModel;

@Repository
public class SupplierDAOimpl implements SupplierDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public void insertSupplierModel(SupplierModel ss) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		CategoryModel cat=new CategoryModel();
		cat.setCategoryId(ss.getCategoryId());
		cat.setCategoryName(ss.getCategoryName());
		cat.setProductId(ss.getProductId());
		cat.setProductName(ss.getProductName());
		ProductModel pro=new ProductModel();
		pro.setProductId(ss.getProductId());
		pro.setProductName(ss.getProductName());
		s.save(pro);
		s.save(cat);
		s.save(ss);
		t.commit();
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	
	public List<SupplierModel> getSupplierList() {
		// TODO Auto-generated method stub
		System.out.println("............"+sessionFactory);
		Session s=sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		System.out.println("in DAO");
		List <SupplierModel> als= new ArrayList<SupplierModel>();
		als=s.createQuery("from SupplierModel").list();
		t.commit();
		return als;
		
	}
	public void update(SupplierModel s) {
		// TODO Auto-generated method stub
		System.out.println("In update product");
		Session s2 = sessionFactory.openSession();
		Transaction t = s2.beginTransaction();
		SupplierModel p1 = (SupplierModel) s2.load(SupplierModel.class, s.getSupplierId());
		if (p1 != null) {
			System.out.println("****inif");
			s2.update(s);
		}
		t.commit();
	}

	@Transactional
	public void remove(int id) {
		// TODO Auto-generated method stub
		Session s2=sessionFactory.openSession();
		Transaction t=s2.beginTransaction();
		SupplierModel s=(SupplierModel)s2.load(SupplierModel.class,new Integer(id));
		if(s!=null)
		{
			s2.delete(s);
		}
		t.commit();
	}

}
