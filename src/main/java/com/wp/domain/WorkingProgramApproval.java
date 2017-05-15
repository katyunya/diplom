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
public class WorkingProgramApproval {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String agency;
	private String date;
	private int doc_number;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgramApproval")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;

	@Override
	public String toString() {
		return "WorkingProgramApproval{" +
				"agency='" + agency + '\'' +
				", date='" + date + '\'' +
				", doc_number=" + doc_number +
				'}';
	}
}
