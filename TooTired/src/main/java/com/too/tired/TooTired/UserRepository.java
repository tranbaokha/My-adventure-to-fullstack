package com.too.tired.TooTired;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public void deleteById(Long id);
	public Optional<UserEntity> findByUsername(String username);
}
