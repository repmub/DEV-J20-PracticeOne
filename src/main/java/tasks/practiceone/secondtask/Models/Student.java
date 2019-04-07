package practiceone.secondtask.Models;

import java.util.Map;

public class Student implements Comparable<Student>{
    private String lastName;
    private int yearOfBirth;
    private UniversityInfo universityInfo;

    public Student(String lastName, int yearOfBirth, UniversityInfo universityInfo){
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.universityInfo = universityInfo;
    }

    @Override
    public int compareTo(Student other) {
        if (getCourse() > other.getCourse())
            return 1;
        if (getCourse() < other.getCourse())
            return -1;

        return lastName.compareTo(other.getLastName());
    }

    public int getCourse() {
        return universityInfo.getCourse();
    }

    public String getLastName() {
        return lastName;
    }
}
