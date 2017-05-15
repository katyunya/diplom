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
public class EduProcessGraph {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String total;
	private String theoretic_edu;
	private String exam_session;
	private String practice;
	private String graduate_work_state_exams;
	private String vacation;
	private String edu_year;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_plan_id", nullable = false)
	private BasePlan basePlan;

	@Override
	public String toString() {
		return "EduProcessGraph{" +
				"total='" + total + '\'' +
				", theoretic_edu='" + theoretic_edu + '\'' +
				", exam_session='" + exam_session + '\'' +
				", practice='" + practice + '\'' +
				", graduate_work_state_exams='" + graduate_work_state_exams + '\'' +
				", vacation='" + vacation + '\'' +
				", edu_year='" + edu_year + '\'' +
				'}';
	}
}
