package info.thecodinglive.querydsl;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class UserEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private Integer age;
	
	private Date createdAt;
	
	@Column(name = "role")
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	
	@PrePersist
	public void beforeCreate() {
		createdAt = new Date();
	}
	
	public UserEntity() {
		
	}
	
	public UserEntity(String username) {
		this.username = username;
	}

	public UserEntity(String username, Integer age, UserRole role) {
		this.username = username;
		this.age = age;
		this.role = role;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
	
}
