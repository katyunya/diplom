package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ControlForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy="controlForm")
	List<DisciplineStructure> disciplineStructureList;

	@Override
	public String toString() {
		return "ControlForm{" +
				"name='" + name + '\'' +
				'}';
	}
}
