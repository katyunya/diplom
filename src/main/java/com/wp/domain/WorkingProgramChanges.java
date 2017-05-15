package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class WorkingProgramChanges {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String agency;
	private String date;
	private int protocol_number;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgramChanges")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;

	@Override
	public String toString() {
		return "WorkingProgramChanges{" +
				"agency='" + agency + '\'' +
				", date='" + date + '\'' +
				", protocol_number=" + protocol_number +
				'}';
	}
}
