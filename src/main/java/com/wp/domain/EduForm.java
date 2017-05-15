package com.wp.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EduForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "eduFormList")
	private List<Specialty> specialtyList;

	@Override
	public String toString() {
		return "EduForm{" +
				"name='" + name + '\'' +
				'}';
	}
}
