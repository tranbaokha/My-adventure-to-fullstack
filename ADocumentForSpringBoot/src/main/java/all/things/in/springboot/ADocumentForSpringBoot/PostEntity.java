package all.things.in.springboot.ADocumentForSpringBoot;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Post")
public class PostEntity {
	@Id
	@GeneratedValue
	@Min(value = 1)
	private int id;
	@Size(min = 1, max = 255)
	private String content;
	@Past
	@Column(name = "postday")
	private LocalDate postDay;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostDay() {
		return this.postDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	public void setPostDay(String postDay) {
		String res = "";
		String[] arr = postDay.split("/");
		for(int i = arr.length - 1; i > 0; i--)
			res += arr[i] + "-";
		res += arr[0];
		this.postDay = LocalDate.parse(res);
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
