package all.things.in.springboot.ADocumentForSpringBoot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityEntityRepository extends JpaRepository<AuthorityEntity, Integer>{

}
