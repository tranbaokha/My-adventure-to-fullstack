package all.things.in.springboot.ADocumentForSpringBoot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;

public class CustomUserDetails implements UserDetails{
	UserEntity user;
	public CustomUserDetails(UserEntity user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	} 
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		Set<GrantedAuthority> authorities = new HashSet<>();
//        for(AuthorityEntity authority : user.getAuthorities()) {
//        	authorities.add(new SimpleGrantedAuthority(authority.getName()));
//        }
//		return authorities;
//		UserEntity temp = userRepository.findById(user.getId()).get();
//		System.out.println(temp.getFullName());
//		return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//	}
	public Collection<? extends GrantedAuthority> authorities;
	public CustomUserDetails(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	public static CustomUserDetails build(UserEntity user) {
		List<GrantedAuthority> authorities = user.getAuthorities().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.collect(Collectors.toList());
		
		return new CustomUserDetails(user, authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserEntity getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}
	
}
