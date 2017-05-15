package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Cathedra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String reduction;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "cathedra")
	List<BasePlan> basePlans;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "cathedra")
	List<User> userList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="cathedra")
	List<ExpertiseFirstLevel> expertiseFirstLevelList;

	@Override
	public String toString() {
		return "Cathedra{" +
				"name='" + name + '\'' +
				", reduction='" + reduction + '\'' +
				'}';
	}
}
