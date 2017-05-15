package com.wp.domain;

import javax.persistence.Column;
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
public class EduProjectPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "OOP_code")
	private String oop_code;
	private String discipline_practice_name;
	private String exam;
	private String credit;
	private String other_control_form;
	private String course_work;
	private String hours_with_exams;
	private String exam_hours;
	private String classroom_hours;
	@Column(name = "KSR")
	private String ksr;
	@Column(name = "SR")
	private String sr;
	private String first_semester;
	private String second_semester;
	private String third_semester;
	private String fourth_semester;
	private String fifth_semester;
	private String sixth_semester;
	private String seventh_semester;
	private String eighth_semester;
	private String laboriousness;
	private String competence_list;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "base_plan_id", nullable = false)
	private BasePlan basePlan;

	@Override
	public String toString() {
		return "EduProjectPlan{" +
				"oop_code='" + oop_code + '\'' +
				", discipline_practice_name='" + discipline_practice_name + '\'' +
				", exam='" + exam + '\'' +
				", credit='" + credit + '\'' +
				", other_control_form='" + other_control_form + '\'' +
				", course_work='" + course_work + '\'' +
				", hours_with_exams='" + hours_with_exams + '\'' +
				", exam_hours='" + exam_hours + '\'' +
				", classroom_hours='" + classroom_hours + '\'' +
				", ksr='" + ksr + '\'' +
				", sr='" + sr + '\'' +
				", first_semester='" + first_semester + '\'' +
				", second_semester='" + second_semester + '\'' +
				", third_semester='" + third_semester + '\'' +
				", fourth_semester='" + fourth_semester + '\'' +
				", fifth_semester='" + fifth_semester + '\'' +
				", sixth_semester='" + sixth_semester + '\'' +
				", seventh_semester='" + seventh_semester + '\'' +
				", eighth_semester='" + eighth_semester + '\'' +
				", laboriousness='" + laboriousness + '\'' +
				", competence_list='" + competence_list + '\'' +
				'}';
	}
}
