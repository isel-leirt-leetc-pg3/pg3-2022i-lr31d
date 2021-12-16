package leirt.pg3.students;

import org.junit.jupiter.api.Test;

import java.util.List;

public class StudentsSemestersTests {
    @Test
    public void add_student_test() {
        StudentsSemesters db = new StudentsSemesters();
        Student s1 = new Student("Carlos", 34777, 2, 15.0f);
        Student s2 = new Student("Carlos", 34777, 2, 15.0f);

        db.addStudentSemester(s1, 4);
        db.addStudentSemester(s2, 5);

        List<Integer> semesters = db.getStudentSemesters(s1);
        System.out.println(semesters);

        List<Integer> semesters2 = db.getStudentSemesters(s2);
        System.out.println(semesters2);
    }
}
