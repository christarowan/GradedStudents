package io.zipcoder;


import java.util.ArrayList;
import java.util.Arrays;


public class Student {


    private String firstName;
    private String lastName;
    private ArrayList<Double> examScores;


    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.examScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {return firstName;}

    public String getLastName() {return lastName;}

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getExamScores() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exam scores:\n");
        for (int i=0; i<examScores.size(); i++) {
            sb.append("Exam "+Integer.toString(i)+"--> ");
            sb.append(Double.toString(examScores.get(i))+"\n");
        }
        return sb.toString();
    }


    public void addExamScore(double examScore) {
        examScores.add(examScore);
    }

    public void setExamScore(int examNumber, double newScore) {
        examScores.set(examNumber,newScore);
    }

    public Double getAverageExamScore() {
        double sum = 0;
        for(int i = 0; i<examScores.size();i++) {
            sum+=examScores.get(i);
        }

        return sum/examScores.size();
    }


}
