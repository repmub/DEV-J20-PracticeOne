package practiceone.secondtask.Models;

import java.util.Map;

public class UniversityInfo {
    private int course;
    private int group;
    private Map<String, Integer> grades;

    public UniversityInfo(int course, int group, Map<String, Integer> grades){
        this.course = course;
        this.group = group;
        this.grades = grades;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup() {
        return group;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}
