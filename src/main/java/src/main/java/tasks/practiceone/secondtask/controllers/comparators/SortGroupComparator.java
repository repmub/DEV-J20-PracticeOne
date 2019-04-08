package practiceone.secondtask.controllers.comparators;

import practiceone.secondtask.Models.Student;

import java.util.Comparator;

public class SortGroupComparator implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        if (firstStudent.getGroup() > secondStudent.getGroup())
            return 1;
        if (firstStudent.getGroup() < secondStudent.getGroup())
            return -1;
        return 0;
    }
}
