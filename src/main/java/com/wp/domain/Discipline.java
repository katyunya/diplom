package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Discipline {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "disciplineList")
	private List<BasePlan> basePlanList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="discipline")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;

	@Override
	public String toString() {
		return "Discipline{" +
				"name='" + name + '\'' +
				'}';
	}
}
