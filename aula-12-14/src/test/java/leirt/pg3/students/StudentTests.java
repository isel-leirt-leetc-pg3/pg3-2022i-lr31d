package leirt.pg3.students;

import org.junit.jupiter.api.Test;

public class StudentTests {
    @Test
    public void add_student_test() {
        SortedStudents ss = new SortedStudents();
        Student s1 = new Student("Carlos", 34777, 2, 15.0f);
        Student s2 = new Student("Carlos", 37656, 2, 15.0f);
        Student s3 = new Student("Alberto", 40656, 2, 15.0f);

        ss.addStudent(s1);
        ss.addStudent(s2);
        ss.addStudent(s3);

        for(Student s : ss) {
            System.out.println(s);
        }
    }
}
