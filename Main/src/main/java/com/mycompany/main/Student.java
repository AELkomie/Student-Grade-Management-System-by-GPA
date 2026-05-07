package com.mycompany.main;

public class Student {

    int studentID;
    String studentName;
    double gpa;

    Student prev;
    Student next;

    public Student(int studentID, String studentName, double gpa) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "ID: " + studentID +
                ", Name: " + studentName +
                ", GPA: " + gpa;
    }
}