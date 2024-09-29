package com.srss_backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srss_backend.entity.Patient;
import com.srss_backend.entity.Users;
import com.srss_backend.repository.UserRepository;

@Service
public class UserService{
	
	@Autowired
	private UserRepository userRepository;

	public List<Users> getAllUser() {
		return userRepository.findAll();
	}
	
	public void saveUsers(Users user) {
		userRepository.save(user);
	}

	public List<Users> getUsersById(Long id) {
		Users user = new Users();
		List<Users> listUsers = new ArrayList<>();
		try {
			user = userRepository.findById(id).get();
			listUsers.add(user);
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Users with id " + id + " not found");
		}
		return listUsers;
	}

}
