package all.things.in.springboot.ADocumentForSpringBoot;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Integer>{
	Optional<UserEntity> findByUsername(String username);
	void deleteById(int id);
}
