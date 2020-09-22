package all.things.in.springboot.ADocumentForSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	private UserEntityRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByUsername(username).get();
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		return CustomUserDetails.build(user);
	}
	public boolean checkLogin(UserEntity user) {
		UserEntity temp = userRepository.findByUsername(user.getUsername()).get();
		if(temp.getPassword().equals(user.getPassword()))
			return true;
		return false;
	}
	
}
