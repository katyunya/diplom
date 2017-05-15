package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ExpertiseFirstLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String date;
	private int protocol_number;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="expertiseFirstLevel")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cathedra_id", nullable = false)
	private Cathedra cathedra;

	@Override
	public String toString() {
		return "ExpertiseFirstLevel{" +
				"date='" + date + '\'' +
				", protocol_number=" + protocol_number +
				", cathedra=" + cathedra.getName() +
				'}';
	}
}
