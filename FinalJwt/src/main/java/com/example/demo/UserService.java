package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username).get();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

	public UserDetails loadUserById(Long userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
            throw new UsernameNotFoundException(userId.toString());
        }
        return new CustomUserDetails(user);
	}

	public boolean checkLogin(User user) {
		User temp = userRepository.findByUsername(user.getUsername()).get();
		if(temp.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}


}
