package com.wp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SRS_control_graph")
@Data
@NoArgsConstructor
public class SrsControlGraph {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int week;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SRS_control_form_id", nullable = false)
	private SrsControlForm srsControlForm;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_id")
	@JsonIgnore
	private WorkingProgram workingProgram;

	@Override
	public String toString() {
		return "SrsControlGraph{" +
				"week=" + week +
				", srsControlForm=" + srsControlForm +
				'}';
	}
}
