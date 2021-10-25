package com.usermanagement.services.impI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.usermanagement.model.User;
import com.usermanagement.repository.UserRepository;
import com.usermanagement.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userRepository.delete(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public User findById(long userId) {
		// TODO Auto-generated method stub
		return (User) userRepository.findById(userId).get();
	}

	@Override
	public boolean isValidUser(String email, String password) {
		// TODO Auto-generated method stub
		User user = findByEmail(email);
		if (user == null) {
			return false;
		}
		String valid_password = user.getPassword();
		return (password.equals(valid_password));
	}
}
