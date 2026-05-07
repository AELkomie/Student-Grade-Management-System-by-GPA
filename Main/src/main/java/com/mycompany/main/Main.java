package com.mycompany.main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        StudentGradeManagementSystem system =
                new StudentGradeManagementSystem();

        int choice;

        do {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Insert Student");
            System.out.println("2. Search Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Print All Students");
            System.out.println("5. Show TOP 10 GPA");
            System.out.println("6. Show TOP 5 IDs");
            System.out.println("7. Show GPA < 2");
            System.out.println("8. Show Size");
            System.out.println("0. Exit");

            System.out.print("\nEnter choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = input.nextInt();

                    input.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = input.nextDouble();

                    Student student =
                            new Student(id, name, gpa);

                    system.insert(student);

                    System.out.println("Student added successfully.");
                    break;

                case 2:

                    System.out.print("Enter Student ID to search: ");
                    int searchID = input.nextInt();

                    Student found = system.search(searchID);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID to remove: ");
                    int removeID = input.nextInt();

                    boolean removed =
                            system.remove(removeID);

                    if (removed) {
                        System.out.println("Student removed.");
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.println("\nALL STUDENTS:");
                    system.printAllStudents();

                    break;

                case 5:

                    system.top10();

                    break;

                case 6:

                    system.top5ByID();

                    break;

                case 7:

                    system.lowGPAStudents();

                    break;

                case 8:

                    System.out.println("Size = " + system.size());

                    break;

                case 0:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        input.close();
    }
}