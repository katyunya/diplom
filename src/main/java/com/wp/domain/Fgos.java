package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "FGOS")
@Data
@NoArgsConstructor
public class Fgos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String name;
	@Lob
	private String application_area;
	@Lob
	private String direction_feature;
	@Lob
	private String prof_activity_feature;
	@Lob
	private String structure_requirements;
	@Lob
	private String basic_edu_programs_requirements;
	@Lob
	private String quality_control;
	
//	@OneToOne(optional = false, mappedBy = "fgos")
//	private BasePlan basePlan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "specialty_id", nullable = false)
	private Specialty specialty;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="fgos")
	List<Competence> competenceList;

	@Override
	public String toString() {
		return "Fgos{" +
				"application_area='" + application_area + '\'' +
				", direction_feature='" + direction_feature + '\'' +
				", prof_activity_feature='" + prof_activity_feature + '\'' +
				", structure_requirements='" + structure_requirements + '\'' +
				", basic_edu_programs_requirements='" + basic_edu_programs_requirements + '\'' +
				", quality_control='" + quality_control + '\'' +
				", specialty=" + specialty.getName() +
				", competenceList=" + competenceList +
				'}';
	}
}
