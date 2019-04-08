package practiceone.secondtask.controllers;

import practiceone.secondtask.Models.*;
import practiceone.secondtask.controllers.comparators.*;

import java.io.*;
import java.util.*;

public class University {
    private List<Student> students = new ArrayList<>();

    public University() throws IOException {
        students = new LoaderOfStudentList().loadStudentList();
    }

    public void loadStudentList() throws IOException {
        students = new LoaderOfStudentList().loadStudentList();
    }

    public void sort(){
        students.sort(new StudentCourseComparator());
    }

    public Map<Integer, AverageGrades> averageGrades() {
        students.sort(new SortGroupComparator());

        Map<Integer, AverageGrades> statisticOfAverageGrades = new HashMap<>();
        AverageGrades averageGrades = new AverageGrades();
        Integer currentGroup = students.get(0).getGroup();

        for (Student student : students) {
            if (!currentGroup.equals(student.getGroup())){
                statisticOfAverageGrades.put(currentGroup, averageGrades);

                averageGrades = new AverageGrades();
                currentGroup = student.getGroup();
            }
            addAverageGradesOfOneGroup(averageGrades, student);
        }
        statisticOfAverageGrades.put(currentGroup, averageGrades);

        return statisticOfAverageGrades;
    }

    private void addAverageGradesOfOneGroup(AverageGrades averageGrades, Student student){
        averageGrades.countStudentsInGroup();
        averageGrades.sumOfMathGrades(student.getGrades().get("math"));
        averageGrades.sumOfPhysicsGrades(student.getGrades().get("physics"));
        averageGrades.sumOfHistoryGrades(student.getGrades().get("history"));
    }

    public Student getEldestStudent(){
        return getYoungestOrEldestStudent(new EldestStudent());
    }

    public Student getYoungestStudent(){
        return getYoungestOrEldestStudent(new YoungestStudent());
    }

    private Student getYoungestOrEldestStudent(Comparator<Student> comparator){
        Student student = students.get(0);

        for (int i = 1; i < students.size(); i++){
            if (comparator.compare(student, students.get(i)) > 0)
                student = students.get(i);
        }
        return student;
    }

    public List<Student> getBestStudents(){
        List<Student> bestStudents = new ArrayList<>();
        students.sort(new SortGroupComparator());

        Student bestStudent = students.get(0);
        for (int i = 1; i < students.size() - 1; i++){
            if (bestStudent.getGroup() == students.get(i).getGroup()) {
                if (new ComparisonOfGrades().compare(bestStudent, students.get(i)) < 0)
                    bestStudent = students.get(i);
            } else {
                bestStudents.add(bestStudent);
                addAnotherBestStudentsInGroup(bestStudents, bestStudent);
                bestStudent = students.get(i);
            }
        }
        bestStudents.add(bestStudent);
        return bestStudents;
    }

    private void addAnotherBestStudentsInGroup(List<Student> bestStudents, Student bestStudent){
        for (Student student : bestStudents){
            if (student.getGroup() != bestStudent.getGroup()) break;
            else if (bestStudent != student) bestStudents.add(student);
        }
    }

    public static void main(String[] args) {
        try {
            University university = new University();
            university.loadStudentList();
            university.sort();
            Map<Integer, AverageGrades> averageGradesOfGroups = university.averageGrades();
            System.out.println(averageGradesOfGroups);
            System.out.println(university.getYoungestStudent());
            System.out.println(university.getEldestStudent());
            System.out.println(university.getBestStudents());
        } catch (IOException e) {
            System.out.println("Error of file reading.");
        }
    }
}
