package StudentManagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            clearScreen();
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.editStudent();
                    break;
                case 3:
                    manager.deleteStudent();
                    break;
                case 4:
                    manager.searchStudent();
                    break;
                case 5:
                    manager.sortStudentsByMarks();
                    manager.displayStudents();
                    break;
                case 6:
                    manager.displayStudents();
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            if (choice != 7) {
                System.out.println("Press Enter to continue...");
                scanner.nextLine(); // Consume newline
                scanner.nextLine(); // Wait for Enter key press
            }
        } while (choice != 7);

        scanner.close();
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Could not clear screen.");
        }
    }
}

class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks);
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int id = scanner.nextInt();
        Student student = searchStudentById(id);
        if (student != null) {
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new marks: ");
            double marks = scanner.nextDouble();
            student.setName(name);
            student.setMarks(marks);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        Student student = searchStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void sortStudentsByMarks() {
        Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Students sorted by marks.");
    }

    public void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();
        Student student = searchStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
