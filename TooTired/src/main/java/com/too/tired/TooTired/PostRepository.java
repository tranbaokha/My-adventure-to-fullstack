package com.too.tired.TooTired;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer>{
	public void deleteById(int id);
}
