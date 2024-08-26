import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    private ArrayList<Student> students;

    public StudentGradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(String name) {
        Student student = new Student(name);
        students.add(student);
        System.out.println("Student added: " + name);
    }

    public void addGrade(String name, double grade) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                student.addGrade(grade);
                System.out.println("Grade added for " + name + ": " + grade);
                return;
            }
        }
        System.out.println("Student not found: " + name);
    }

    public void printGrades(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                System.out.println("Grades for " + name + ":");
                for (double grade : student.getGrades()) {
                    System.out.println(grade);
                }
                return;
            }
        }
        System.out.println("Student not found: " + name);
    }

    public void calculateAverage(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                double average = student.calculateAverage();
                System.out.println("Average grade for " + name + ": " + average);
                return;
            }
        }
        System.out.println("Student not found: " + name);
    }

    public static void main(String[] args) {
        StudentGradeTracker tracker = new StudentGradeTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add student");
            System.out.println("2. Add grade");
            System.out.println("3. Print grades");
            System.out.println("4. Calculate average");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    tracker.addStudent(name);
                    break;
                case 2:
                    System.out.print("Enter student name: ");
                    name = scanner.next();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    tracker.addGrade(name, grade);
                    break;
                case 3:
                    System.out.print("Enter student name: ");
                    name = scanner.next();
                    tracker.printGrades(name);
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    name = scanner.next();
                    tracker.calculateAverage(name);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}

class Student {
    private String name;
    private ArrayList<Double> grades;

    public Student(String name) {
        this.name = name;
        grades = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
