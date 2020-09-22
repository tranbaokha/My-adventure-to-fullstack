package all.things.in.springboot.ADocumentForSpringBoot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue
	@Min(value = 1)
	private int id;
	@Column(name = "fullname")
	private String fullName;
	@Size(min = 6, max = 10)
	private String username;
	@Size(min = 6, max = 20)
	private String password;
	@Past
	private LocalDate birthday;
	@OneToMany(mappedBy="user")
	private List<PostEntity> posts;
	@ManyToMany(mappedBy = "user", fetch= FetchType.EAGER)
	@JsonIgnore
	private List<AuthorityEntity> authorities;
	public List<AuthorityEntity> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(List<AuthorityEntity> authorities) {
		this.authorities = authorities;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthday() {
		return this.birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setBirthday(String birthday) {
		String res = "";
		String[] arr = birthday.split("/");
		for(int i = arr.length - 1; i > 0; i--) {
			res += arr[i] + "-";
		}
		res += arr[0];
		this.birthday = LocalDate.parse(res);
	}
	public List<PostEntity> getPosts() {
		return posts;
	}
	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}
}
