package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Specialty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
//	@OneToOne(optional = false, mappedBy="specialty")
//	private BasePlan basePlan;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="specialty")
	List<Fgos> fgosList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="specialty")
	List<Competence> competenceList;
	
	@ManyToMany
	@JoinTable(name = "specialty_has_edu_form", 
	joinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "edu_form_id", referencedColumnName = "id"))
	private List<EduForm> eduFormList;
	
	@ManyToMany
	@JoinTable(name = "specialty_has_qualification", 
	joinColumns = @JoinColumn(name = "specialty_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "qualification_id", referencedColumnName = "id"))
	private List<Qualification> qualificationList;

	@Override
	public String toString() {
		return "Specialty{" +
				"name='" + name + '\'' +
				", competenceList=" + competenceList +
				", eduFormList=" + eduFormList +
				", qualificationList=" + qualificationList +
				'}';
	}
}
