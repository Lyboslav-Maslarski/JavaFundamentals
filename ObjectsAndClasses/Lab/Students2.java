package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    static class Student {
        private String firstName;

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getFirstName() {
            return firstName;
        }

        private String lastName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        private int age;

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        private String city;

        public void setCity(String city) {
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] info = input.split("\\s+");
            if (isStudentExist(students, info[0], info[1])) {
                Student student = getStudent(students, info[0], info[1]);
                student.setAge(Integer.parseInt(info[2]));
                student.setCity(info[3]);
            } else {
                Student student = new Student(info[0], info[1], Integer.parseInt(info[2]), info[3]);
                students.add(student);
            }
            input = scan.nextLine();
        }
        String command = scan.nextLine();
        for (Student student : students) {
            if (command.equals(student.getCity())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }

    static boolean isStudentExist(List<Student> students, String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    private static Student getStudent(List<Student> students, String firstName, String lastName) {
        Student existingStudent = null;
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }
}