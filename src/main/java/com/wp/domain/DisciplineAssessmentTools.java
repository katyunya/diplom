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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DisciplineAssessmentTools {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String theme;
	@Lob
	private String questions;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="disciplineAssessmentTools")
	List<ProgressControlForm> progressControlForms;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_id")
	@JsonIgnore
	private WorkingProgram workingProgram;

	@Override
	public String toString() {
		return "DisciplineAssessmentTools{" +
				"theme='" + theme + '\'' +
				", questions='" + questions + '\'' +
				", progressControlForms=" + progressControlForms +
				'}';
	}
}
