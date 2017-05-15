package com.wp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class SelfStudyProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String competence_code;
	@Lob
	private String theme;
	@Lob
	private String materials;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_id")
	@JsonIgnore
	private WorkingProgram workingProgram;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SRS_form_id", nullable = false)
	private SrsForm srsForm;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SRS_kind_id", nullable = true)
	private SrsKind srsKind;

	@Override
	public String toString() {
		return "SelfStudyProgram{" +
				"competence_code='" + competence_code + '\'' +
				", theme='" + theme + '\'' +
				", materials='" + materials + '\'' +
				", srsForm=" + srsForm +
				", srsKind=" + srsKind +
				'}';
	}
}
