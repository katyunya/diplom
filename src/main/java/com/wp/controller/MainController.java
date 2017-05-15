package com.wp.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.wp.domain.*;
import com.wp.pojo.UserEditForm;
import com.wp.pojo.UserForm;
import com.wp.pojo.WorkingProgramForm;
import com.wp.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private WorkingProgramRepository workingProgramRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private DegreesRepository degreesRepository;
    @Autowired
    private AcademicTitleRepository academicTitleRepository;
    @Autowired
    private CathedraRepository cathedraRepository;
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private ControlFormRepository controlFormRepository;
    @Autowired
    private SrsFormRepository srsFormRepository;
    @Autowired
    private SrsKindRepository srsKindRepository;
    @Autowired
    private ProgressControlFormRepository progressControlFormRepository;
    @Autowired
    private SrsControlFormRepository srsControlFormRepository;
    @Autowired
    private ExpertiseFirstLevelRepository expertiseFirstLevelRepository;
    @Autowired
    private BasePlanRepository basePlanRepository;

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("userList", userRepository.findAll());
        return "index";
    }

    @RequestMapping(value = "/working-programs")
    public String workingPrograms(Model model) {
        model.addAttribute("workingPrograms", workingProgramRepository.findAll());
        return "working_programs";
    }

    @RequestMapping(value = "/getWP/{id}")
    public String getWP(@PathVariable("id") int id, Model model) {
        model.addAttribute("workingProgram", workingProgramRepository.findById(id));
        return "working_program";
    }

    @RequestMapping(value = "/personal")
    public String personal_area(Model model, Principal principal) {
        model.addAttribute("workingPrograms", workingProgramRepository.findByUserId(userRepository.findByLogin(principal.getName()).getId()));
        model.addAttribute("user", userRepository.findByLogin(principal.getName()));
        return "personal_area";
    }

    @RequestMapping(value = "/edit-personal", method = RequestMethod.GET)
    public String editPersonal(Model model, Principal principal) {
        UserEditForm editUser = new UserEditForm();
        User user = userRepository.findByLogin(principal.getName());
        editUser.setLogin(user.getLogin());
        editUser.setName(user.getName());
        editUser.setPassword(user.getPassword());
        editUser.setName(user.getName());
        editUser.setPost(user.getPost().getName());
        model.addAttribute("user", editUser);
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("academic_title", academicTitleRepository.findAll());
        model.addAttribute("degrees", degreesRepository.findAll());
        model.addAttribute("cathedraList", cathedraRepository.findAll());
        return "edit_personal";
    }

    @RequestMapping(value = "/edit-personal", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("user") UserEditForm userEditForm) {
        User user = userRepository.findByLogin(userEditForm.getLogin());
        user.setName(userEditForm.getName());
        user.setPassword(userEditForm.getPassword());
        Post post = postRepository.findById(Integer.parseInt(userEditForm.getPost()));
        if (userEditForm.getAcademicTitle() != null) {
            AcademicTitle academicTitle = academicTitleRepository.findById(Integer.parseInt(userEditForm.getAcademicTitle()));
            user.setAcademicTitle(academicTitle);
        }
        if (userEditForm.getDegrees() != null) {
            Degrees degree = degreesRepository.findById(Integer.parseInt(userEditForm.getDegrees()));
            user.setDegrees(degree);
        }
        Cathedra cathedra = cathedraRepository.findById(Integer.parseInt(userEditForm.getCathedra()));
        user.setPost(post);
        user.setCathedra(cathedra);
        userRepository.save(user);
        return "redirect:/personal";
    }

    @RequestMapping(value = "/create-wp", method = RequestMethod.GET)
    public String createWP(Model model) {
        model.addAttribute("disciplineList", disciplineRepository.findAll());
        model.addAttribute("competenceList", competenceRepository.findAll());
        model.addAttribute("controlForms", controlFormRepository.findAll());
        model.addAttribute("srsForms", srsFormRepository.findAll());
        model.addAttribute("srsKindLis", srsKindRepository.findAll());
        model.addAttribute("progressControlForms", progressControlFormRepository.findAll());
        model.addAttribute("srsControlForms", srsControlFormRepository.findAll());
        model.addAttribute("cathedraList", cathedraRepository.findAll());
        model.addAttribute("workingProgram", new WorkingProgramForm());
        return "create_working_program";
    }

    @RequestMapping(value = "/create-wp", method = RequestMethod.POST)
    public String addWP(@ModelAttribute("workingProgram") WorkingProgramForm workingProgramForm, Principal principal, Model model) {
        WorkingProgram workingProgram = new WorkingProgram();

        workingProgram.setName(workingProgramForm.getName());
        workingProgram.setGoal(workingProgramForm.getGoal());
        workingProgram.setDiscipline_place(workingProgramForm.getDiscipline_place());
        workingProgram.setKnow(workingProgramForm.getKnow());
        workingProgram.setCan(workingProgramForm.getCan());
        workingProgram.setBe_skilled(workingProgramForm.getBe_skilled());
        workingProgram.setEdu_technologies(workingProgramForm.getEdu_technologies());
        workingProgram.setHours(Integer.parseInt(workingProgramForm.getHours()));
        workingProgram.setSelf_study(Integer.parseInt(workingProgramForm.getSelf_study()));
        workingProgram.setAll_hours(Integer.parseInt(workingProgramForm.getAll_hours()));

        DisciplineStructure disciplineStructure = new DisciplineStructure();
        disciplineStructure.setTheme(workingProgramForm.getDisciplineTheme());
        disciplineStructure.setSemester_week(workingProgramForm.getSemester_week());
        disciplineStructure.setLecture(workingProgramForm.getLecture());
        disciplineStructure.setPractical(workingProgramForm.getPractical());
        disciplineStructure.setLab(workingProgramForm.getLabHours());
        disciplineStructure.setSrs(workingProgramForm.getSrs());
        disciplineStructure.setCompetence_number(Integer.parseInt(workingProgramForm.getCompetence_number()));
        ControlForm controlForm = controlFormRepository.findById(Integer.parseInt(workingProgramForm.getControlForm()));
        disciplineStructure.setControlForm(controlForm);
        List<Competence> competenceList = new ArrayList<>();
        for (Integer i : workingProgramForm.getCompetenceList()) {
            Competence competence = competenceRepository.findById(i);
            competenceList.add(competence);
        }
        disciplineStructure.setCompetenceList(competenceList);
        disciplineStructure.setWorkingProgram(workingProgram);
        List<DisciplineStructure> disciplineStructureList = new ArrayList<>();
        disciplineStructureList.add(disciplineStructure);
        workingProgram.setDisciplineStructureList(disciplineStructureList);

        LecturesContent lecturesContent = new LecturesContent();
        lecturesContent.setTheme(workingProgramForm.getLecturesTheme());
        lecturesContent.setContent(workingProgramForm.getLecturesContent());
        lecturesContent.setWorkingProgram(workingProgram);
        List<LecturesContent> lecturesContentList = new ArrayList<>();
        lecturesContentList.add(lecturesContent);
        workingProgram.setLecturesContentList(lecturesContentList);

        PracticalTrainingProgram practicalTrainingProgram = new PracticalTrainingProgram();
        practicalTrainingProgram.setTheme(workingProgramForm.getPracticalTheme());
        practicalTrainingProgram.setPractical_lesson(workingProgramForm.getPracticalLesson());
        practicalTrainingProgram.setWorkingProgram(workingProgram);
        List<PracticalTrainingProgram> practicalTrainingProgramList = new ArrayList<>();
        practicalTrainingProgramList.add(practicalTrainingProgram);
        workingProgram.setPracticalTrainingProgramList(practicalTrainingProgramList);

        LabPracticalProgram labPracticalProgram = new LabPracticalProgram();
        labPracticalProgram.setTheme(workingProgramForm.getLabTheme());
        labPracticalProgram.setLab(workingProgramForm.getLab());
        labPracticalProgram.setWorkingProgram(workingProgram);
        List<LabPracticalProgram> labPracticalProgramList = new ArrayList<>();
        labPracticalProgramList.add(labPracticalProgram);
        workingProgram.setLabPracticalProgramList(labPracticalProgramList);

        SelfStudyProgram selfStudyProgram = new SelfStudyProgram();
        selfStudyProgram.setCompetence_code(workingProgramForm.getCompetence_code());
        selfStudyProgram.setTheme(workingProgramForm.getSelfStudyTheme());
        selfStudyProgram.setMaterials(workingProgramForm.getMaterials());
        SrsForm srsForm = srsFormRepository.findById(Integer.parseInt(workingProgramForm.getSrsForm()));
        selfStudyProgram.setSrsForm(srsForm);
        if (workingProgramForm.getSrsKind() != "") {
            SrsKind srsKind = srsKindRepository.findById(Integer.parseInt(workingProgramForm.getSrsKind()));
            selfStudyProgram.setSrsKind(srsKind);
        }
        selfStudyProgram.setWorkingProgram(workingProgram);
        List<SelfStudyProgram> selfStudyProgramList = new ArrayList<>();
        selfStudyProgramList.add(selfStudyProgram);
        workingProgram.setSelfStudyProgramList(selfStudyProgramList);

        SrsContent srsContent = new SrsContent();
        srsContent.setTheme(workingProgramForm.getSrsTheme());
        srsContent.setWorkingProgram(workingProgram);
        List<SrsContent> srsContentList = new ArrayList<>();
        srsContentList.add(srsContent);
        workingProgram.setSrsContentList(srsContentList);

        SrsControlGraph srsControlGraph = new SrsControlGraph();
        srsControlGraph.setWeek(Integer.parseInt(workingProgramForm.getSrsWeek()));
        SrsControlForm srsControlForm = srsControlFormRepository.findById(Integer.parseInt(workingProgramForm.getSrsControlForm()));
        srsControlGraph.setSrsControlForm(srsControlForm);
        srsControlGraph.setWorkingProgram(workingProgram);
        List<SrsControlGraph> srsControlGraphList = new ArrayList<>();
        srsControlGraphList.add(srsControlGraph);
        workingProgram.setSrsControlGraphList(srsControlGraphList);

        DisciplineAssessmentTools disciplineAssessmentTools = new DisciplineAssessmentTools();
        disciplineAssessmentTools.setTheme(workingProgramForm.getAssessmentToolsTheme());
        disciplineAssessmentTools.setQuestions(workingProgramForm.getQuestions());
        ProgressControlForm progressControlForm = progressControlFormRepository.findById(Integer.parseInt(workingProgramForm.getProgressControlForm()));
        List<ProgressControlForm> progressControlFormList = new ArrayList<>();
        progressControlFormList.add(progressControlForm);
        disciplineAssessmentTools.setProgressControlForms(progressControlFormList);
        disciplineAssessmentTools.setWorkingProgram(workingProgram);
        List<DisciplineAssessmentTools> disciplineAssessmentToolsList = new ArrayList<>();
        disciplineAssessmentToolsList.add(disciplineAssessmentTools);
        workingProgram.setDisciplineAssessmentTools(disciplineAssessmentToolsList);

        DisciplineProvision disciplineProvision = new DisciplineProvision();
        disciplineProvision.setLiterature(workingProgramForm.getLiterature());
        disciplineProvision.setLiterature_form(workingProgramForm.getLiterature_form());
        disciplineProvision.setWorkingProgram(workingProgram);
        List<DisciplineProvision> disciplineProvisionList = new ArrayList<>();
        disciplineProvisionList.add(disciplineProvision);
        workingProgram.setDisciplineProvisionList(disciplineProvisionList);

        ClassroomReq classroomReq = new ClassroomReq();
        classroomReq.setRequirements(workingProgramForm.getClassroomRequirements());
        classroomReq.setEquipment_req(workingProgramForm.getEquipment_req());
        classroomReq.setCount(Integer.parseInt(workingProgramForm.getClassroomCount()));
        classroomReq.setWorkingProgram(workingProgram);
        List<ClassroomReq> classroomReqList = new ArrayList<>();
        classroomReqList.add(classroomReq);
        workingProgram.setClassroomReqList(classroomReqList);

        SpecialReq specialReq = new SpecialReq();
        specialReq.setRequirements(workingProgramForm.getSpecialRequirements());
        specialReq.setCount(Integer.parseInt(workingProgramForm.getSpecialCount()));
        specialReq.setSpecial_po_req(workingProgramForm.getSpecial_po_req());
        specialReq.setWorkingProgram(workingProgram);
        List<SpecialReq> specialReqList = new ArrayList<>();
        specialReqList.add(specialReq);
        workingProgram.setSpecialReqList(specialReqList);

        ConsumablesReq consumablesReq = new ConsumablesReq();
        consumablesReq.setRequirements(workingProgramForm.getConsumablesRequirements());
        consumablesReq.setCount(Integer.parseInt(workingProgramForm.getComsumablesCount()));
        consumablesReq.setUnits(workingProgramForm.getUnits());
        consumablesReq.setWorkingProgram(workingProgram);
        List<ConsumablesReq> consumablesReqList = new ArrayList<>();
        consumablesReqList.add(consumablesReq);
        workingProgram.setConsumablesReqList(consumablesReqList);

        Discipline discipline = disciplineRepository.findById(Integer.parseInt(workingProgramForm.getDiscipline()));
        workingProgram.setDiscipline(discipline);

        User user = userRepository.findByLogin(principal.getName());
        workingProgram.setUser(user);

        ExpertiseFirstLevel expertiseFirstLevel = new ExpertiseFirstLevel();
        expertiseFirstLevel.setDate(workingProgramForm.getExpertiseDate());
        expertiseFirstLevel.setProtocol_number(Integer.parseInt(workingProgramForm.getProtocol_number()));
        Cathedra cathedra = cathedraRepository.findById(Integer.parseInt(workingProgramForm.getCathedra()));
        expertiseFirstLevel.setCathedra(cathedra);
        expertiseFirstLevelRepository.save(expertiseFirstLevel);
        workingProgram.setExpertiseFirstLevel(expertiseFirstLevel);

        workingProgramRepository.save(workingProgram);
        return "redirect:/working_programs";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.GET)
    public String addUser(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("user", new UserForm());
        return "add_user";
    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserForm userForm, Model model) {
        User user = new User();
        user.setLogin(userForm.getLogin());
        user.setName(userForm.getName());
        user.setPassword(userForm.getPassword());
        Post post = postRepository.findById(Integer.parseInt(userForm.getPost()));
        user.setPost(post);
        userRepository.save(user);
        return "redirect:/home";
    }

    @RequestMapping(value = "downloadPDF/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadPDF(@PathVariable("id") int id) throws DocumentException, IOException {
        WorkingProgram workingProgram = workingProgramRepository.findById(id);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        BaseFont bf = BaseFont.createFont("fonts/TimesNewRomanRegular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //подключаем файл шрифта, который поддерживает кириллицу
        Font font = new Font(bf);
        document.open();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_PDF);
        document.add(new Paragraph(workingProgram.toString(), font));
        document.close();
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();
        return new ResponseEntity<byte[]>(pdfBytes, httpHeaders, HttpStatus.OK);
    }
}
