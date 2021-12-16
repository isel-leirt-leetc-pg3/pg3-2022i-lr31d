package leirt.pg3.students;

public class Student implements Comparable<Student> {
    public final int number;
    public final String name;
    public final int numUnits;
    public final float averageGrade;

    public Student(String name, int number, int numUnits, float avrGrade) {
        this.number = number;
        this.name = name;
        this.numUnits = numUnits;
        this.averageGrade = avrGrade;
    }

    public float getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int hashCode() {
        return name.hashCode() ^ Integer.hashCode(number);
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() != o.getClass()) return false;
        Student other = (Student) o;
        return name.equals(other.name) &&
            number == other.number;
    }

    public String toString() {
        return name + ", "
            + number + ", "
            + numUnits + ", "
            + averageGrade;
    }

    @Override
    public int compareTo(Student o) {
        int res = name.compareTo(o.name);
        if (res != 0) return res;
        return Integer.compare(number, o.number);
    }
}
