package com.niit.Mhub.dao;

import java.util.List;

import com.niit.Mhub.model.SignupModel;

public interface UserDAO {
	public void insertSignupModel(SignupModel u);

	public boolean isValidUser(String un, String pd);

	public boolean isAdminUser(String un, String pd);

	public List<SignupModel> getSignupList();

	public void update(SignupModel p);

	public void remove(int id);

}
