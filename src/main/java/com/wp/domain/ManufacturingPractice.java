package com.wp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ManufacturingPractice {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private int semester;
	private int count_weeks;
	private String control_form;
	private int laboriousness;
	private int hours;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_plan_id", nullable = false)
	private BasePlan basePlan;

	@Override
	public String toString() {
		return "ManufacturingPractice{" +
				"name='" + name + '\'' +
				", semester=" + semester +
				", count_weeks=" + count_weeks +
				", control_form='" + control_form + '\'' +
				", laboriousness=" + laboriousness +
				", hours=" + hours +
				'}';
	}
}
