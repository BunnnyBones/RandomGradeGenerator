package com.company.models;

public class Student {

    private final String name;
    private String grade;
    private final int percentGrade;

    public Student(String name, int percentGrade){
        this.name = name;
        this.percentGrade = percentGrade;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getPercentGrade() {
        return percentGrade;
    }
}
