package com.team7.librarian.service;

import com.team7.librarian.model.User;

public interface SecurityService {
	public User getLoggedInUser();
	public void setSecurityContext(User user);
}
