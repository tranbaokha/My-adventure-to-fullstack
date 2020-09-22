package all.things.in.springboot.ADocumentForSpringBoot;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class AuthorityEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@ManyToMany(fetch= FetchType.EAGER)
	@JoinTable (
			name = "user_authority",
			joinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
	)
	private List<UserEntity> user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserEntity> getUser() {
		return user;
	}
	public void setUser(List<UserEntity> user) {
		this.user = user;
	} 
}
