package info.thecodinglive.model;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String userName;
	private String grade;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHOOL_ID")
	private School school;
	
	public School getSchool() {
		return school;
	}
	
	public void setSchool(School school) {
		this.school = school;
	}
	
	public Student(String userName) {
		this.userName = userName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
