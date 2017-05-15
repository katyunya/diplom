package com.wp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ProgressControlForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String form;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "discipline_assessment_tools_id", nullable = false)
	private DisciplineAssessmentTools disciplineAssessmentTools;

	@Override
	public String toString() {
		return "ProgressControlForm{" +
				"form='" + form + '\'' +
				'}';
	}
}
