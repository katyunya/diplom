package com.wp.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Max;
import java.util.List;

@Data
@NoArgsConstructor
public class WorkingProgramForm {
    private String name;
    private String goal;
    private String discipline_place;
    private String know;
    private String can;
    private String be_skilled;
    private String edu_technologies;
    private String hours;
    private String self_study;
    private String all_hours;

    //disciplineStructure
    private String disciplineTheme;
    private String semester_week;
    private Integer lecture;
    private Integer practical;
    private Integer labHours;
    private Integer srs;
    private String competence_number;
    private List<Integer> competenceList;
    private String controlForm;

    //lecturesContent
    private String lecturesTheme;
    private String lecturesContent;

    //practicalTrProgram
    private String practicalTheme;
    private String practicalLesson;

    //labPrProgram
    private String labTheme;
    private String lab;

    //selfStudy
    private String competence_code;
    private String selfStudyTheme;
    private String materials;
    private String srsForm;
    private String srsKind;

    //srsContent
    private String srsTheme;

    //srsControlGraph????!!!
    private String srsWeek;
    private String srsControlForm;

    //disciplineAssTools
    private String assessmentToolsTheme;
    private String questions;
    //List
    private String progressControlForm;

    //disciplineProvision
    private String literature;
    private String literature_form;

    //classromReq
    private String classroomRequirements;
    private String equipment_req;
    private String classroomCount;

    //specialReq
    private String specialRequirements;
    private String specialCount;
    private String special_po_req;

    //consumablesReq
    private String consumablesRequirements;
    private String comsumablesCount;
    private String units;

    private String discipline;
    private String user;

    //expertiseFirstLevel
    private String expertiseDate;
    private String protocol_number;
    private String cathedra;

    //can be null
    private String expertiseSecondLevel;
    private String otherDocuments;
    private String workingProgramApproval;
    private String workingProgramChanges;

}
