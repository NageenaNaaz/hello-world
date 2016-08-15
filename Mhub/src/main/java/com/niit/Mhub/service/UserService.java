package com.niit.Mhub.service;

import java.util.List;

import com.niit.Mhub.model.SignupModel;

public interface UserService {
	public void insertSignupModel(SignupModel u);

	public List<SignupModel> getSignupList();

	public void update(SignupModel p);

	public void remove(int id);

}
