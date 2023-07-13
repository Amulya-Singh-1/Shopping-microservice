package com.userService.Service;

import java.util.List;

import com.userService.Entity.User;

public interface userService {
	public User getUser(Integer id);
	public List<User> getAllUsers();
	public User addUser(User u);
	public User updateUser(User u);
	public String deleteUser(Integer id);
}
