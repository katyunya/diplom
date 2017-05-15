package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class BasePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String name;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="basePlan")
	List<EduProjectPlan> plans;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="basePlan")
	List<EduProcessGraph> graphs;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="basePlan")
	List<FinalStateCertification> fsc;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="basePlan")
	List<ManufacturingPractice> manuPracticeList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="basePlan")
	List<EduPractice> eduPracticeList;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cathedra_id", nullable = false)
	private Cathedra cathedra;

	@OneToOne(optional = false)
	@JoinColumn(name = "specialty_id", unique = true, nullable = false)
	private Specialty specialty;

	@OneToOne(optional = false)
	@JoinColumn(name = "FGOS_id", unique = true, nullable = false)
	private Fgos fgos;

	@ManyToMany
	@JoinTable(name = "base_plan_has_discipline", 
	joinColumns = @JoinColumn(name = "base_plan_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "discipline_id", referencedColumnName = "id"))
	private List<Discipline> disciplineList;

	@Override
	public String toString() {
		return "BasePlan{" +
				"name='" + name + '\'' +
				", plans=" + plans +
				", graphs=" + graphs +
				", fsc=" + fsc +
				", manuPracticeList=" + manuPracticeList +
				", eduPracticeList=" + eduPracticeList +
				", cathedra=" + cathedra.getName() +
				", specialty=" + specialty.getName() +
				", disciplineList=" + disciplineList +
				'}';
	}
}
