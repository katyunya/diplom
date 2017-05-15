package com.wp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SRS_content")
@Data
@NoArgsConstructor
public class SrsContent {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String theme;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_id")
	@JsonIgnore
	private WorkingProgram workingProgram;

	@Override
	public String toString() {
		return "SrsContent{" +
				"theme='" + theme + '\'' +
				'}';
	}
}
