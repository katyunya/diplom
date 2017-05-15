package com.wp.domain;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String login;
	private String password;

	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cathedra_id", nullable = true)
	private Cathedra cathedra;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "degrees_id", nullable = true)
	private Degrees degrees;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "academic_title_id", nullable = true)
	private AcademicTitle academicTitle;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "post_id", nullable = false)
	private Post post;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="user")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;


	//shit
	public int getColumnCount() {
		return getClass().getDeclaredFields().length;
	}



	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", cathedra=" + cathedra +
				", degrees=" + degrees +
				", academicTitle=" + academicTitle +
				", post=" + post +
				'}';
	}
}
