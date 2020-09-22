package com.too.tired.TooTired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.lang.Collections;

public class UserEntityDetail implements UserDetails{
	 	UserEntity userEntity;
	 	
	 	public UserEntityDetail(UserEntity userEntity) {
			this.userEntity = userEntity;
		}
	 	public UserEntity getUserEntity() {
	 		return this.userEntity;
	 	}
	 	public void setUserEntity(UserEntity userEntity) {
	 		this.userEntity = userEntity;
	 	}
		@Override
	    public List<GrantedAuthority> getAuthorities() {
	 		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	 		authorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));
	 		return authorities;
	    }

	    @Override
	    public String getPassword() {
			return userEntity.getPassword();
	    }

	    @Override
	    public String getUsername() {
	        return userEntity.getUsername();
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }
}
