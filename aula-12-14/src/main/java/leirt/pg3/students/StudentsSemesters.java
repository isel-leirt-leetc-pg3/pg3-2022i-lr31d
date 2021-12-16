package leirt.pg3.students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentsSemesters {
    private final HashMap<Student, List<Integer>> map;

    public StudentsSemesters() {
        map = new HashMap<>();
    }

    public void addStudentSemester(Student student, int semester) {
        List<Integer> semesters = map.get(student);
        if (semesters == null) { // inexistent student
            semesters = new ArrayList<>();
            map.put(student, semesters);
        }
        semesters.add(semester);
    }

    public List<Integer> getStudentSemesters(Student s) {
        return map.get(s);
    }
}
