package gb.hw.education.controllers;

import gb.hw.education.data.classes.EducationGroup;
import gb.hw.education.data.classes.Student;
import gb.hw.education.data.classes.Teacher;
import gb.hw.education.services.classes.EducationGroupService;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class GroupController {
    private static final EducationGroupService service = new EducationGroupService();

    public static EducationGroup newGroup(){
        List<Student> students = new ArrayList<>();

        students.add(new Student("Ivanov", "12.10.2000", 1));
        students.add(new Student("Petrov", "12.10.2000", 2));
        students.add(new Student("Sidorov", "12.10.2000", 3));
        students.add(new Student("Kovaleva", "12.10.2000", 4));
        students.add(new Student("Zotova", "12.10.2000", 5));

        return new EducationGroup(1, "gr-1", new Teacher("Pavlov", "14.05.1990",1, "teacher"), students);
    }

    public static EducationGroup readGroup(String fileName){
        return service.loadGroupFromTxt(fileName);
    }

    public static void saveGroup(String fileName, EducationGroup group){
        service.saveGroupToTxt(fileName, group);
    }

}
