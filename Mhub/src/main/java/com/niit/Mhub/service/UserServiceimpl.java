package com.niit.Mhub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Mhub.dao.UserDAO;
import com.niit.Mhub.model.SignupModel;

@Service
public class UserServiceimpl implements UserService{
	@Autowired
	UserDAO userDAO;
	
	public void insertSignupModel(SignupModel u)
	{
		userDAO.insertSignupModel(u);
	}
	
	public List<SignupModel> getSignupList() {
		// TODO Auto-generated method stub
		System.out.println("In SERVICE");
		List<SignupModel> a=userDAO.getSignupList();
		System.out.println(a);
		return a;
	}

	@Override
	public void update(SignupModel p) {
		// TODO Auto-generated method stub

		userDAO.update(p);
	}

	@Override
	public void remove(int id) {
		// TODO Auto-generated method stub
		userDAO.remove(id);
	}
	

}

