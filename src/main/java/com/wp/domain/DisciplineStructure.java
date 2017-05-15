package com.wp.domain;

import java.util.List;

import javax.persistence.Column;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DisciplineStructure {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String theme;
	private String semester_week;
	private int lecture;
	private int practical;
	private int lab;
	@Column(name = "SRS")
	private int srs;
	private int competence_number;
	
	@ManyToMany
	@JoinTable(name = "discipline_structure_has_competence", 
	joinColumns = @JoinColumn(name = "discipline_structure_id", referencedColumnName = "id"), 
	inverseJoinColumns = @JoinColumn(name = "competence_id", referencedColumnName = "id"))
	private List<Competence> competenceList;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "control_form_id")
	private ControlForm controlForm;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_id")
	@JsonIgnore
	private WorkingProgram workingProgram;

	@Override
	public String toString() {
		return "DisciplineStructure{" +
				"theme='" + theme + '\'' +
				", semester_week='" + semester_week + '\'' +
				", lecture=" + lecture +
				", practical=" + practical +
				", lab=" + lab +
				", srs=" + srs +
				", competence_number=" + competence_number +
				", competenceList=" + competenceList +
				", controlForm=" + controlForm +
				'}';
	}
}
