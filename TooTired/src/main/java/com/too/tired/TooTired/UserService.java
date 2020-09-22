package com.too.tired.TooTired;

import java.util.Optional;

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
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return new UserEntityDetail(user.get());
    }
    public UserDetails loadUserById(int userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        return new UserEntityDetail(user.get());
    }

}