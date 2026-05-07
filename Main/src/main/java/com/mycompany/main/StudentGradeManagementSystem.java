package com.mycompany.main;

import java.util.ArrayList;

public class StudentGradeManagementSystem {

    private Student head;
    private Student tail;
    private int size;

    // INSERT STUDENT
    public void insert(Student newStudent) {

        // Empty list
        if (head == null) {
            head = tail = newStudent;
            size++;
            return;
        }

        // Insert at beginning
        if (newStudent.gpa < head.gpa) {
            newStudent.next = head;
            head.prev = newStudent;
            head = newStudent;
            size++;
            return;
        }

        Student current = head;

        // Find correct position
        while (current.next != null &&
                current.next.gpa < newStudent.gpa) {
            current = current.next;
        }

        // Insert at end
        if (current.next == null) {
            current.next = newStudent;
            newStudent.prev = current;
            tail = newStudent;
        }

        // Insert in middle
        else {

            newStudent.next = current.next;
            newStudent.prev = current;

            current.next.prev = newStudent;
            current.next = newStudent;
        }

        size++;
    }

    // SEARCH BY ID
    public Student search(int studentID) {

        Student current = head;

        while (current != null) {

            if (current.studentID == studentID) {
                return current;
            }

            current = current.next;
        }

        return null;
    }

    // REMOVE BY ID
    public boolean remove(int studentID) {

        Student studentToRemove = search(studentID);

        if (studentToRemove == null) {
            return false;
        }

        // Remove head
        if (studentToRemove == head) {
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
        }

        // Remove tail
        if (studentToRemove == tail) {
            tail = tail.prev;

            if (tail != null) {
                tail.next = null;
            }
        }

        // Remove middle
        if (studentToRemove.prev != null) {
            studentToRemove.prev.next = studentToRemove.next;
        }

        if (studentToRemove.next != null) {
            studentToRemove.next.prev = studentToRemove.prev;
        }

        size--;
        return true;
    }

    // SIZE
    public int size() {
        return size;
    }

    // PRINT ALL
    public void printAllStudents() {

        if (head == null) {
            System.out.println("No students found.");
            return;
        }

        Student current = head;

        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    // TOP 10 GPA
    public void top10() {

        if (tail == null) {
            System.out.println("No students found.");
            return;
        }

        Student current = tail;

        int count = 0;

        System.out.println("\nTOP 10 STUDENTS BY GPA:");

        while (current != null && count < 10) {

            System.out.println(current);

            current = current.prev;
            count++;
        }
    }
    
    // TOP 5 IDs
    public void top5ByID() {

        ArrayList<Student> students = new ArrayList<>();

        Student current = head;

        while (current != null) {
            students.add(current);
            current = current.next;
        }

        students.sort((s1, s2) ->
                Integer.compare(s2.studentID, s1.studentID));

        System.out.println("\nTOP 5 STUDENTS BY ID:");

        for (int i = 0; i < Math.min(5, students.size()); i++) {
            System.out.println(students.get(i));
        }
    }
 
    // GPA < 2
    public void lowGPAStudents() {

        Student current = head;

        boolean found = false;

        System.out.println("\nSTUDENTS WITH GPA < 2:");

        while (current != null) {

            if (current.gpa < 2.0) {
                System.out.println(current);
                found = true;
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("No students found.");
        }
    }
}