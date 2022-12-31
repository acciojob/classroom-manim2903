package com.driver;

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public Teacher(String name, int age, int numberOfStudents) {
        this.name=name;
        this.age=age;
        this.numberOfStudents=numberOfStudents;
    }
}