package practiceone.secondtask.Models;

public class AverageGrades {
    private Double sumOfMathGrades = 0.;
    private Double sumOfPhysicsGrades = 0.;
    private Double sumOfHistoryGrades = 0.;
    private Integer counterOfStudentsInGroup = 0;

    public void countStudentsInGroup() {
        ++counterOfStudentsInGroup;
    }

    public void sumOfMathGrades(Integer math) {
        this.sumOfMathGrades += math;
    }

    public void sumOfPhysicsGrades(Integer physics) {
        this.sumOfPhysicsGrades += physics;
    }

    public void sumOfHistoryGrades(Integer history) {
        this.sumOfHistoryGrades += history;
    }

    public Integer getCounterOfStudentsInGroup() {
        return counterOfStudentsInGroup;
    }

    public Double getMathAverageGrades() {
        return sumOfMathGrades/counterOfStudentsInGroup;
    }

    public Double getPhysicsAverageGrades() {
        return sumOfPhysicsGrades/counterOfStudentsInGroup;
    }

    public Double getHistoryAverageGrades() {
        return sumOfHistoryGrades/counterOfStudentsInGroup;
    }

    @Override
    public String toString() {
        return  "Math: " + getMathAverageGrades() + ", Physics: " + getPhysicsAverageGrades() + ", History: " + getHistoryAverageGrades();
    }
}
