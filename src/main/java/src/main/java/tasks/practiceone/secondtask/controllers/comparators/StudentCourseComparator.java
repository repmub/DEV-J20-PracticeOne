package practiceone.secondtask.controllers.comparators;

import practiceone.secondtask.Models.Student;

import java.util.Comparator;

public class StudentCourseComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        return firstStudent.compareTo(secondStudent);
    }
}
