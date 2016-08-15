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
import com.niit.Mhub.model.SupplierModel;

@Repository
public class CategoryDAOimpl implements CategoryDAO{

	@Autowired(required=true)
	private SessionFactory sessionFactory;
	@Transactional
	public void insertCategoryModel(CategoryModel c) {
		// TODO Auto-generated method stub
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		s.save(c);
		t.commit();
	}
	// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		@Transactional(propagation=Propagation.SUPPORTS)
		public List<CategoryModel> getCategoryList() {
			// TODO Auto-generated method stub

			System.out.println("............."+sessionFactory);
			Session s=sessionFactory.openSession();
			Transaction t=s.beginTransaction();
			List<CategoryModel> al=new ArrayList<CategoryModel>();
			al=s.createQuery("from CategoryModel").list();
			t.commit();
			return al;
			
		}
		//edit or update category
				public void update(CategoryModel a) {
					// TODO Auto-generated method stub
					System.out.println("In update category");
					Session s=sessionFactory.openSession();
					Transaction t = s.beginTransaction();
					CategoryModel c1=(CategoryModel)s.load(CategoryModel.class,a.getCategoryId());
					if(c1!=null)
					{
						System.out.println("****inif");
						s.update(a);
					}
					t.commit();

				}
				@Transactional
				public void remove(int id) {
					// TODO Auto-generated method stub
					Session s=sessionFactory.openSession();
					Transaction t=s.beginTransaction();
					CategoryModel a=(CategoryModel)s.load(CategoryModel.class,new Integer(id));
					if(a!=null)
					{
						s.delete(a);
					}
					t.commit();
				}
}
