package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
    private JwtTokenProvider tokenProvider;
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/api/login")
	 public ResponseEntity<String> login(HttpServletRequest request, @RequestBody User user) {
	    String result = "";
	    HttpStatus httpStatus = null;
	    try {
	      if (userService.checkLogin(user)) {
	        result = tokenProvider.generateToken(user.getUsername());
	        httpStatus = HttpStatus.OK;
	      } else {
	        result = "Wrong userId and password";
	        httpStatus = HttpStatus.BAD_REQUEST;
	      }
	    } catch (Exception ex) {
	      result = "Server Error";
	      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	    }
	    return new ResponseEntity<String>(result, httpStatus);
	  }
	@GetMapping("api/test")
	public String test() {
		return "Hello World";
	}
	//@PreAuthorize("hasRole('"+ "ROLE_USER" + "')")
	@GetMapping("/api/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	@GetMapping("/api/user")
	public User getUserByUsername(){
		return userRepository.findByUsername("kha").get();
	}
}
