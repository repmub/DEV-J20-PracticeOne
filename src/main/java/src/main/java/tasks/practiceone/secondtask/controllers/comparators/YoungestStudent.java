package practiceone.secondtask.controllers.comparators;

import practiceone.secondtask.Models.Student;

import java.util.Comparator;

public class YoungestStudent implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        if (firstStudent.getYearOfBirth() > secondStudent.getYearOfBirth())
            return 1;
        if (firstStudent.getYearOfBirth() < secondStudent.getYearOfBirth())
            return -1;
        return 0;
    }
}
