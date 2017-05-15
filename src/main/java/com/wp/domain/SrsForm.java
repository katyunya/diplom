package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SRS_form")
@Data
@NoArgsConstructor
public class SrsForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="srsForm")
	List<SelfStudyProgram> selfStudyProgramList;

	@Override
	public String toString() {
		return "SrsForm{" +
				"name='" + name + '\'' +
				'}';
	}
}
