package ObjectsAndClasses.Exercise;

import java.util.*;

public class Students {
    static class Student {
        private String firstName;

        public String getFirstName() {
            return firstName;
        }

        private String lastName;

        public String getLastName() {
            return lastName;
        }

        private double grade;

        public double getGrade() {
            return grade;
        }

        Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] studentInfo = scan.nextLine().split(" ");
            Student student = new Student(studentInfo[0], studentInfo[1], Double.parseDouble(studentInfo[2]));
            studentList.add(student);
        }

        studentList.sort(Comparator.comparingDouble(Student::getGrade).reversed());

        for (Student student : studentList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
