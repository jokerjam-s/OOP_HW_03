package gb.hw.education.controllers;

import gb.hw.education.data.classes.EducationGroup;
import gb.hw.education.data.classes.Stream;
import gb.hw.education.data.classes.Student;
import gb.hw.education.data.classes.Teacher;
import gb.hw.education.data.interfaces.IStream;
import gb.hw.education.services.classes.EducationGroupService;
import gb.hw.education.services.classes.StreamService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupController {
    private static final StreamService streamService = new StreamService();
    private static final EducationGroupService groupService = new EducationGroupService();
    // Номер последней созданной группы
    private static int lastGroupNumber = 0;

    /**
     * Генератор нового потока
     * @param name              - наименование потока
     * @param countGroups       - кол-во групп в потоке
     * @param minStudentCount   - минимальное кол-во студентов в группе
     * @param maxStudentCount   - максимальное кол-во студентов в группе
     * @return                  - новый поток
     */
    public static IStream newStream(String name,  int countGroups, int minStudentCount, int maxStudentCount){
        IStream stream = new Stream(name);
        Random random = new Random();

        for (int i = 0; i < countGroups; i++) {
            stream.addGroup(newGroup(random.nextInt(minStudentCount, maxStudentCount)));
        }

        return stream;
    }

    /**
     * Генератор новой группы
     * @param countStudent  - количество студентов в группе
     * @return              - созданнуб группу
     */
    public static EducationGroup newGroup(int countStudent){
        List<Student> students = new ArrayList<>();

        for (int i=1; i<=countStudent; i++){
            students.add(new Student(String.format("%dй студент", i), "12.10.2000", i));
        }

        lastGroupNumber++;

        return new EducationGroup(lastGroupNumber,
                String.format("группа %d", lastGroupNumber),
                new Teacher("Pavlov", "14.05.1990",1, "teacher"),
                students);
    }

    public static EducationGroup readGroup(String fileName){
        return groupService.loadGroupFromTxt(fileName);
    }

    public static void saveGroup(String fileName, EducationGroup group){
        groupService.saveGroupToTxt(fileName, group);
    }

}
