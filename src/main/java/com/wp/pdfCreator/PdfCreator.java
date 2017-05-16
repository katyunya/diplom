package com.wp.pdfCreator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.wp.domain.*;
import com.wp.repository.WorkingProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class PdfCreator {
    @Autowired
    WorkingProgramRepository workingProgramRepository;

    public byte[] createPDF(int id) throws DocumentException, IOException {
        WorkingProgram workingProgram = workingProgramRepository.findById(id);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, byteArrayOutputStream);
        BaseFont bf = BaseFont.createFont("fonts/TimesNewRomanRegular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED); //подключаем файл шрифта, который поддерживает кириллицу
        Font font = new Font(bf);
        document.open();

        Chapter chapter = new Chapter(1);
        chapter.add(new Paragraph(workingProgram.getName() + " " + workingProgram.getDiscipline().getName(), font));
        chapter.add(new Paragraph("1. Цели и задачи освоения дисциплины", font));
        chapter.add(new Paragraph(workingProgram.getGoal(), font));
        chapter.add(new Paragraph("2. Место дисциплины в структуре ООП магистратуры", font));
        chapter.add(new Paragraph(workingProgram.getDiscipline_place(), font));
        chapter.add(new Paragraph("3. В результате изучения дисциплины студент должен знать:", font));
        chapter.add(new Paragraph(workingProgram.getKnow(), font));
        chapter.add(new Paragraph("уметь:", font));
        chapter.add(new Paragraph(workingProgram.getCan(), font));
        chapter.add(new Paragraph("владеть навыками:", font));
        chapter.add(new Paragraph(workingProgram.getBe_skilled(), font));
        chapter.add(new Paragraph("4. Структура дисциплины по видам учебной работы, соотношение тем и формируемых компетенций", font));
        for (DisciplineStructure ds : workingProgram.getDisciplineStructureList()) {
            chapter.add(new Paragraph("Тема: " + ds.getTheme(), font));
            chapter.add(new Paragraph("Неделя семестра: " + ds.getSemester_week(), font));
            chapter.add(new Paragraph("Лекций" + String.valueOf(ds.getLecture()), font));
            chapter.add(new Paragraph("Практических занятий: " + String.valueOf(ds.getPractical()), font));
            chapter.add(new Paragraph("Самостоятельная работа студента: " + String.valueOf(ds.getSrs()), font));
            chapter.add(new Paragraph("Лабораторные: " + String.valueOf(ds.getLab()), font));
            chapter.add(new Paragraph("Количество компетенций: " + String.valueOf(ds.getCompetence_number()), font));
            chapter.add(new Paragraph("Компетенции: ", font));
            for (Competence c : ds.getCompetenceList()) {
                chapter.add(new Paragraph(c.getName(), font));
            }
            chapter.add(new Paragraph("Форма контроля: " + ds.getControlForm().getName(), font));
        }
        chapter.add(new Paragraph("5. Содержание лекционных занятий", font));
        for (LecturesContent lc : workingProgram.getLecturesContentList()) {
            chapter.add(new Paragraph("Тема: " + lc.getTheme(), font));
            chapter.add(new Paragraph("Содержание: " + lc.getContent(), font));
        }
        chapter.add(new Paragraph("6. Программа практических/семинарских занятий", font));
        for (PracticalTrainingProgram pr : workingProgram.getPracticalTrainingProgramList()) {
            chapter.add(new Paragraph("Тема: " + pr.getTheme(), font));
            chapter.add(new Paragraph("Практическое занятие: " + pr.getPractical_lesson(), font));
        }
        chapter.add(new Paragraph("7. Программа лабораторных занятий", font));
        for (LabPracticalProgram lab : workingProgram.getLabPracticalProgramList()) {
            chapter.add(new Paragraph("Тема: " + lab.getTheme(), font));
            chapter.add(new Paragraph("Лабораторная: " + lab.getLab(), font));
        }
        chapter.add(new Paragraph("Образовательные технологии", font));
        chapter.add(new Paragraph(workingProgram.getEdu_technologies(), font));
        chapter.add(new Paragraph("8. Программа самостоятельной работы студента", font));
        for (SelfStudyProgram srs : workingProgram.getSelfStudyProgramList()) {
            chapter.add(new Paragraph("Код компетенции" + srs.getCompetence_code(), font));
            chapter.add(new Paragraph("Тема: " + srs.getTheme(), font));
            chapter.add(new Paragraph("Материалы: " + srs.getMaterials(), font));
            chapter.add(new Paragraph("Форма контроля: " + srs.getSrsForm().getName(), font));
            chapter.add(new Paragraph("Вид контроля: " + srs.getSrsKind().getName(), font));
        }
        chapter.add(new Paragraph("9. Содержание СРС", font));
        for (SrsContent srsContent : workingProgram.getSrsContentList()) {
            chapter.add(new Paragraph("Тема: " + srsContent.getTheme(), font));
        }
        chapter.add(new Paragraph("10. График контроля самостоятельной работы студента", font));
        for (SrsControlGraph srsGraph : workingProgram.getSrsControlGraphList()) {
            chapter.add(new Paragraph("Неделя: " + srsGraph.getWeek(), font));
            chapter.add(new Paragraph("Форма контроля: " + srsGraph.getSrsControlForm().getName(), font));
        }
        chapter.add(new Paragraph("11. Оценочные средства для текущего контроля успеваемости, промежуточной аттестации по итогам освоения дисциплины", font));
        for (DisciplineAssessmentTools dat : workingProgram.getDisciplineAssessmentTools()) {
            chapter.add(new Paragraph("Тема: " + dat.getTheme(), font));
            chapter.add(new Paragraph("Вопросы: " + dat.getQuestions(), font));
            chapter.add(new Paragraph("Форма контроля: " + dat.getProgressControlForms().get(0).getForm(), font));
        }
        chapter.add(new Paragraph("11. Учебно-методическое и информационное обеспечение дисциплины", font));
        for (DisciplineProvision dp : workingProgram.getDisciplineProvisionList()) {
            chapter.add(new Paragraph("Литература: " + dp.getLiterature(), font));
            chapter.add(new Paragraph("Форма литературы: " + dp.getLiterature_form(), font));
        }
        chapter.add(new Paragraph("12. Материально-техническое обеспечение дисциплины", font));
        for (ClassroomReq cr : workingProgram.getClassroomReqList()) {
            chapter.add(new Paragraph("Требования к аудитории: " + cr.getRequirements(), font));
            chapter.add(new Paragraph("Требования к оборудованию: " + cr.getEquipment_req(), font));
            chapter.add(new Paragraph("Количество: " + cr.getCount(), font));
        }
        for (SpecialReq sr : workingProgram.getSpecialReqList()) {
            chapter.add(new Paragraph("Требования: " + sr.getRequirements(), font));
            chapter.add(new Paragraph("Количество: " + sr.getCount(), font));
            chapter.add(new Paragraph("Требования к специализированному ПО: " + sr.getSpecial_po_req(), font));
        }
        chapter.add(new Paragraph("13. Требования к расходным материалам", font));
        for (ConsumablesReq conr : workingProgram.getConsumablesReqList()) {
            chapter.add(new Paragraph("Требования: " + conr.getRequirements(), font));
            chapter.add(new Paragraph("Количество: " + conr.getCount(), font));
            chapter.add(new Paragraph("Мера измерения: " + conr.getUnits(), font));
        }
        chapter.add(new Paragraph("Регламент утверждения рабочей программы дисциплины ", font));
        chapter.add(new Paragraph("Разработчик рабочей программы: " + workingProgram.getUser().getName(), font));
        chapter.add(new Paragraph("Экспертиза первого уровня", font));
        chapter.add(new Paragraph("Дата: " + workingProgram.getExpertiseFirstLevel().getDate(), font));
        chapter.add(new Paragraph("Номер протокола: " + workingProgram.getExpertiseFirstLevel().getProtocol_number(), font));

        document.add(chapter);

        document.close();
        byte[] pdfBytes = byteArrayOutputStream.toByteArray();
        return pdfBytes;
    }
}
