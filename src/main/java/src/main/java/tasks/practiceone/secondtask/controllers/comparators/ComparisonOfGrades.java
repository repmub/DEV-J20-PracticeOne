package practiceone.secondtask.controllers.comparators;

import practiceone.secondtask.Models.Student;

import java.util.Comparator;

public class ComparisonOfGrades implements Comparator<Student> {
    @Override
    public int compare(Student firstStudent, Student secondStudent) {
        int sumOfFirstStudentGrades = firstStudent.getGrades().get("math") + firstStudent.getGrades().get("physics") +
                                    firstStudent.getGrades().get("history");

        int sumOfSecondStudentGrades = secondStudent.getGrades().get("math") + secondStudent.getGrades().get("physics") +
                                    secondStudent.getGrades().get("history");

        if (sumOfFirstStudentGrades > sumOfSecondStudentGrades)
            return 1;
        if (sumOfFirstStudentGrades < sumOfSecondStudentGrades)
            return -1;
        return 0;
    }
}
