package practiceone.secondtask.controllers;

import practiceone.secondtask.Models.Student;
import practiceone.secondtask.Models.UniversityInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoaderOfStudentList {

    public List<Student> loadStudentList() throws IOException {
        List<Student> students = new ArrayList<>();

        try (ReaderFromFile reader = new ReaderFromFile()){
            while (reader.ready()) {
                if (reader.readElement().matches("<student>"))
                    students.add(makeStudent(reader));
            }
        }
        return students;
    }

    private Student makeStudent(ReaderFromFile reader) throws IOException {
        String lastName = "";
        int yearOfBirth = 0, course = 0, group = 0;
        Map<String, Integer> grades = new HashMap<>();
        String currentElement;

        while (!(currentElement = reader.readElement()).matches("</student>")){

            if (currentElement.matches("<lastName>.+")) {
                lastName = getContent(currentElement);
                continue;
            }
            if (currentElement.matches("<yearOfBirth>.+")) {
                yearOfBirth = Integer.parseInt(getContent(currentElement));
                continue;
            }
            if (currentElement.matches("<course>.+")) {
                course = Integer.parseInt(getContent(currentElement));
                continue;
            }
            if (currentElement.matches("<group>.+")) {
                group = Integer.parseInt(getContent(currentElement));
                continue;
            }
            if (currentElement.matches("<math>.+")) {
                Integer grade = Integer.parseInt(getContent(currentElement));
                grades.put("math", grade);
                continue;
            }
            if (currentElement.matches("<physics>.+")) {
                Integer grade = Integer.parseInt(getContent(currentElement));
                grades.put("physics", grade);
                continue;
            }
            if (currentElement.matches("<history>.+")) {
                Integer grade = Integer.parseInt(getContent(currentElement));
                grades.put("history", grade);
            }
        }
        UniversityInfo info = new UniversityInfo(course, group, grades);
        return new Student(lastName, yearOfBirth, info);
    }

    private String getContent(String element){
        return element.replaceAll("<[^>]+>", "");
    }
}
