package com.wp.domain;

import java.util.List;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Entity
@Data
@NoArgsConstructor
public class WorkingProgram {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Lob
	private String name;
	@Lob
	private String goal;
	@Lob
	private String discipline_place;
	@Lob
	private String know;
	@Lob
	private String can;
	@Lob
	private String be_skilled;
	@Lob
	private String edu_technologies;
	private int hours;
	private int self_study;
	private int all_hours;

//	@ManyToMany//(cascade = CascadeType.ALL)
//	@JoinTable(name = "competence_has_working_program",
//	joinColumns = @JoinColumn(name = "working_program_id", referencedColumnName = "id"),
//	inverseJoinColumns = @JoinColumn(name = "competence_id", referencedColumnName = "id"))
//	private List<Competence> competenceList;

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<DisciplineStructure> disciplineStructureList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<LecturesContent> lecturesContentList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<PracticalTrainingProgram> practicalTrainingProgramList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<LabPracticalProgram> labPracticalProgramList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<SelfStudyProgram> selfStudyProgramList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<SrsContent> srsContentList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<SrsControlGraph> srsControlGraphList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<DisciplineAssessmentTools> disciplineAssessmentTools;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<DisciplineProvision> disciplineProvisionList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<ClassroomReq> classroomReqList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<SpecialReq> specialReqList;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="workingProgram", cascade = CascadeType.ALL)
	List<ConsumablesReq> consumablesReqList;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "discipline_id", nullable = false)
	private Discipline discipline;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "expertise_first_level_id", nullable = false)
	private ExpertiseFirstLevel expertiseFirstLevel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "expertise_second_level_id", nullable = false)
	private ExpertiseSecondLevel expertiseSecondLevel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "other_documents_id", nullable = true)
	private OtherDocuments otherDocuments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_approval_id", nullable = true)
	private WorkingProgramApproval workingProgramApproval;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "working_program_changes_id", nullable = true)
	private WorkingProgramChanges workingProgramChanges;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@Override
	public String toString() {
		return "WorkingProgram{" +
				"name='" + name + '\'' +
				", goal='" + goal + '\'' +
				", discipline_place='" + discipline_place + '\'' +
				", know='" + know + '\'' +
				", can='" + can + '\'' +
				", be_skilled='" + be_skilled + '\'' +
				", edu_technologies='" + edu_technologies + '\'' +
				", hours=" + hours +
				", self_study=" + self_study +
				", all_hours=" + all_hours +
//				", competenceList=" + competenceList +
				", disciplineStructureList=" + disciplineStructureList +
				", lecturesContentList=" + lecturesContentList +
				", practicalTrainingProgramList=" + practicalTrainingProgramList +
				", labPracticalProgramList=" + labPracticalProgramList +
				", selfStudyProgramList=" + selfStudyProgramList +
				", srsContentList=" + srsContentList +
				", srsControlGraphList=" + srsControlGraphList +
				", disciplineAssessmentTools=" + disciplineAssessmentTools +
				", disciplineProvisionList=" + disciplineProvisionList +
				", classroomReqList=" + classroomReqList +
				", specialReqList=" + specialReqList +
				", consumablesReqList=" + consumablesReqList +
				", discipline=" + discipline +
				", expertiseFirstLevel=" + expertiseFirstLevel +
				", expertiseSecondLevel=" + expertiseSecondLevel +
				", otherDocuments=" + otherDocuments +
				", workingProgramApproval=" + workingProgramApproval +
				", workingProgramChanges=" + workingProgramChanges +
				", user=" + user +
				'}';
	}
}
