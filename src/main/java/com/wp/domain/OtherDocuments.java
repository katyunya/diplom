package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OtherDocuments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String document;
	private String date;
	private int protocol_number;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="otherDocuments")
	@JsonIgnore
	List<WorkingProgram> workingProgramList;

	@Override
	public String toString() {
		return "OtherDocuments{" +
				"document='" + document + '\'' +
				", date='" + date + '\'' +
				", protocol_number=" + protocol_number +
				'}';
	}
}
