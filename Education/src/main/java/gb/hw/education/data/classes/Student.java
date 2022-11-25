package gb.hw.education.data.classes;

import gb.hw.education.data.interfaces.IPerson;

import java.io.Serializable;
import java.util.Objects;

/**
 * Класс студент, наследуется от интерфейса Person
 */

public class Student implements IPerson, Serializable {
    private String name;
    private String birthDate;
    private int StudentId;

    public Student(String name, String birthDate, int studentId) {
        this.name = name;
        this.birthDate = birthDate;
        StudentId = studentId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int studentId) {
        StudentId = studentId;
    }

    @Override
    public String toString() {
        return "Студент [" +
                "№ ст. билета: " + StudentId +
                ", ФИО: " + name +
                ", дата рожд.: " + birthDate + ']';
    }

    /**
     * Сравнение проводим только по студенческому билету,
     * даты рождения могут совпадать, как и ФИО причем полностью
     * @param o - объект для сравнения
     * @return  - результат сравнения объектов
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return StudentId == student.StudentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentId, 27);
    }
}
