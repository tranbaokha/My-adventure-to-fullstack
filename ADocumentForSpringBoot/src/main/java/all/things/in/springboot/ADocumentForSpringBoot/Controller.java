package all.things.in.springboot.ADocumentForSpringBoot;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.catalina.mapper.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
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
	private UserEntityRepository userRepository;
	@Autowired
	private PostEntityRepository postRepository;
	@Autowired
	private AuthorityEntityRepository authorityRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenProvider tokenProvider; 
	@Autowired
	private UserService userService;
	//@PreAuthorize("hasRole('" + "ROLE_ADMIN" + "')")
	@GetMapping("/users")
	public OutputFormat<UserEntity> getAllUsers() {
		return new OutputFormat<UserEntity>(1, "Success", userRepository.findAll());
	}
	//@PreAuthorize("hasRole('" + "ROLE_USER" + "')")
	@GetMapping("/users/{id}")
	public OutputFormat<UserEntity> getUserById(@PathVariable int id) {
		UserEntity res = userRepository.findById(id).get();
		//UserOutput userOutput = simpleMapper.entityToOutput(res);
		List<UserEntity> data = new ArrayList<UserEntity>();
		data.add(res);
		return new OutputFormat<UserEntity> (1, "Success", data);
	}
	@PostMapping("/users")
	public ResponseEntity addUser(@Valid @RequestBody UserEntity newUser) {
		userRepository.save(newUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void removeUserById(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	@PutMapping("/users/{id}")
	public void modifyUser(@PathVariable int id, @RequestBody UserEntity newUser) {
		UserEntity user = userRepository.findById(id).get();
		user.setId(newUser.getId());
		user.setFullName(newUser.getFullName());
		user.setUsername(newUser.getUsername());
		user.setPassword(newUser.getPassword());
		user.setBirthday(newUser.getBirthday());
		userRepository.save(user);
	}
	@GetMapping("/users/{id}/posts")
	public OutputFormat<PostEntity> getAllPosts(@PathVariable int id){
		UserEntity user = userRepository.findById(id).get();
		return new OutputFormat<PostEntity>(1, "Success", user.getPosts());
	}
	@PostMapping("/users/{id}/posts")
	public ResponseEntity createNewPost(@PathVariable int id, @RequestBody PostEntity post) {
		UserEntity user = userRepository.findById(id).get();
		post.setUser(user);
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@PostMapping("/login")
	 public OutputFormat<TokenFormat> login(HttpServletRequest request, @RequestBody UserEntity user) {
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
	    List<TokenFormat> data = new ArrayList<TokenFormat>();
		data.add(new TokenFormat(result));
	    return new OutputFormat<TokenFormat>(200, "Success", data);
	  }
	@GetMapping("/test")
	public UserEntity a() {
		return userRepository.findById(11).get();
	}
}















