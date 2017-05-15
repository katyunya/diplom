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
public class FinalStateCertification {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String practice_name;
	private int semester;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_plan_id", nullable = false)
	private BasePlan basePlan;

	@Override
	public String toString() {
		return "FinalStateCertification{" +
				"practice_name='" + practice_name + '\'' +
				", semester=" + semester +
				'}';
	}
}
