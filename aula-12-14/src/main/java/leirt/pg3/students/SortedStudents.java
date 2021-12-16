package leirt.pg3.students;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedStudents implements Iterable<Student> {
    private final TreeSet<Student> students;

    public SortedStudents() {

        students = new TreeSet<>();
    }

    public boolean addStudent(Student s) {

        return students.add(s);
    }

    @Override
    public Iterator<Student> iterator() {
        return students.iterator();
    }
}
