package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class Competence {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String name;
	@Lob
	private String content;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "specialty_id", nullable = false)
	private Specialty specialty;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FGOS_id", nullable = false)
	private Fgos fgos;

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "competenceList")
	private List<DisciplineStructure> disciplineStructureList;

//	@LazyCollection(LazyCollectionOption.FALSE)
//	@ManyToMany(mappedBy = "competenceList")
//	@JsonIgnore
//	private List<WorkingProgram> workingProgramList;

	@Override
	public String toString() {
		return "Competence{" +
				"name='" + name + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
