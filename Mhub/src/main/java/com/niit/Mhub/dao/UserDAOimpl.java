package com.niit.Mhub.dao;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Mhub.model.SignupModel;
import com.niit.Mhub.model.UserDetails;

@Repository
public class UserDAOimpl implements UserDAO{
	

    @Transactional
	public void insertSignupModel(SignupModel u)
	{
		Session s=this.sessionFactory.openSession();
		Transaction t=s.beginTransaction();
		UserDetails user=new UserDetails();
		user.setUserName(u.getUserName());
		user.setPassword(u.getPassword());
		s.save(user);
		s.save(u);
		t.commit();
	}
    Logger log = LoggerFactory.getLogger(UserDAOimpl.class);
	 
	@Autowired
	private SessionFactory sessionFactory;   
	
	public UserDAOimpl() {}
		
	public UserDAOimpl(SessionFactory sessionFactory) {
		try {
			this.sessionFactory = sessionFactory;
		} catch (Exception e) {
			log.error(" Unable to connect to db");
			e.printStackTrace();
		}
	}
@Transactional
	@Override
	public boolean isValidUser(String un, String pd) {
		// TODO Auto-generated method stub
    	System.out.println("UserDAOImpl - isValidUser() started");
		String hql = "from UserDetails where username= '" + un + "' and " + " password ='" + pd + "'";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Query query = sessionFactory.openSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		for(UserDetails u : list){
			System.out.println(u.isadmin());
		}
		if (list != null && !list.isEmpty()) {
			return true;
		}
		System.out.println("isValidUser() ended");
		return false;
	}
    @Transactional
	public boolean isAdminUser(String un, String pd){
		System.out.println("UserDAOImpl - isValidUser() started");
		String hql = "from UserDetails where username= '" + un + "' and " + " password ='" + pd + "'";
		//Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Query query = sessionFactory.openSession().createQuery(hql);		
		boolean res=false;
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		for(UserDetails u : list){			
			System.out.println(u.isadmin());
			res = u.isadmin();
		}
		return res;
	}

    @SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.SUPPORTS)
	public List<SignupModel> getSignupList() {
    	// TODO Auto-generated method stub
    			System.out.println("-----------  " + sessionFactory);
    			Session s = sessionFactory.openSession();
    			Transaction t = s.beginTransaction();
    			System.out.println("In dao ");
    			List<SignupModel> al = new ArrayList<SignupModel>();
    			al = s.createQuery("from SignupModel").list();
    			t.commit();
    			return al;

	}

	@Override
	public void update(SignupModel p) {
		// TODO Auto-generated method stub
		  System.out.println("In update User");
			Session s = sessionFactory.openSession();
			Transaction t = s.beginTransaction();
			SignupModel p1 = (SignupModel) s.load(SignupModel.class, p.getUserId());
			if (p1 != null) {
				System.out.println("****inif");
				s.update(p);
			}
			t.commit();
	}

	@Transactional
	public void remove(int id) {
		// TODO Auto-generated method stub
				Session s=sessionFactory.openSession();
				Transaction t=s.beginTransaction();
				SignupModel p=(SignupModel)s.load(SignupModel.class,new Integer(id));
				if(p!=null)
				{
					s.delete(p);
				}
				t.commit();
			}

	
}

