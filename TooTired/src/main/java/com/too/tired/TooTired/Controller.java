package com.too.tired.TooTired;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class Controller {
	@Autowired
	private UserRepository userRepository;
	@Autowired 
	private PostRepository postRepository;
	@Autowired
	private JwtTokenProvider tokenProvider;
	@Autowired
    AuthenticationManager authenticationManager;
	@GetMapping("/users")
	public  OutputFormat<UserEntity> getAllUser() {
		return new OutputFormat<UserEntity>(1, "Success", userRepository.findAll(), null); 
	}
	@GetMapping("/users/{id}")
	public OutputFormat<UserEntity> getUserById(@PathVariable int id){
		Optional<UserEntity>oldUser = userRepository.findById(id);
		if(!oldUser.isPresent()) {
			//throw new 
		}
		return new OutputFormat<UserEntity>(1, "Success", null, userRepository.findById(id).get());
	}
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody UserEntity user) {
		Optional<UserEntity> oldUser = userRepository.findById(user.getId());
		userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PutMapping("/users/{id}")
	public void updateUser(@RequestBody @Valid UserEntity user, @PathVariable int id) {
		Optional<UserEntity> oldUser = userRepository.findById(id);
		oldUser.get().setName(user.getName());
		oldUser.get().setBirthday(user.getBirthday());
		userRepository.save(oldUser.get());
	}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	@GetMapping("/users/{id}/posts")
	public OutputFormat<PostEntity> getAllPost(@PathVariable int id){
		Optional<UserEntity> user = userRepository.findById(id);
		return new OutputFormat<PostEntity>(1, "Success", user.get().getPosts(),null);
	}
	@GetMapping("/users/{id}/posts/{postId}")
	public OutputFormat<PostEntity> getPostById(@PathVariable int id, @PathVariable int postId){
		Optional<UserEntity> user = userRepository.findById(id);
		return new OutputFormat<PostEntity>(1, "Success", null, user.get().getPosts(postId));
	}
	@GetMapping("/posts")
	public OutputFormat<PostEntity> getAllPosts(){
		return new OutputFormat<PostEntity>(1, "Success", postRepository.findAll(), null);
	}
	@GetMapping("/posts/{id}")
	public OutputFormat<PostEntity> getPostById(@PathVariable int id){
		return new OutputFormat<PostEntity>(1, "Success", null, postRepository.findById(id).get());
	}
	@PostMapping("/users/{id}/posts")
	public ResponseEntity<Object> addPost(@RequestBody PostEntity post, @PathVariable int id){
		Optional<UserEntity> user = userRepository.findById(id);
		post.setUser(user.get());
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/users/{id}/posts").buildAndExpand(user.get().getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/posts/{postId}")
	public void DeletePost(@PathVariable int postId) {
		postRepository.deleteById(postId);
	}
	@PutMapping("/posts/{postId}")
	public void updatePost(@PathVariable int postId, @RequestBody PostEntity post) {
		Optional<PostEntity> oldPost = postRepository.findById(postId);
		oldPost.get().setContent(post.getContent());
		postRepository.save(oldPost.get());
	}
	@PostMapping("/login")
	public ResponseEntity<String> login(HttpServletRequest request, @RequestBody UserEntity user) {
	    String result = "";
	    HttpStatus httpStatus = null;
	    try {
	      Optional<UserEntity>userTemp = userRepository.findByUsername(user.getUsername());
	      if (userTemp.get().getPassword().equals(user.getUsername())) {
	    	  UserEntityDetail userDetail = new UserEntityDetail(user);
	        result = tokenProvider.generateToken(userDetail);
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
	@GetMapping("/test")
	public String a() {
		return "Hello";
	}
}
