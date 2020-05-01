package com.infobeans.loginservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infobeans.loginservice.model.User;
import com.infobeans.loginservice.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public void saveUser(User user) {
		try {
			user.setCreditcardDetails(passwordEncoder().encode(user.getCreditcardDetails()));
		user.setPass(passwordEncoder().encode(user.getPass()));
			userRepository.save(user);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
