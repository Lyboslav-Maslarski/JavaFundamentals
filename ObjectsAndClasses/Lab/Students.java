package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students {
    static class Student {
        private String firstName;

        public String getFirstName() {
            return firstName;
        }

        String setFirstName() {
            return firstName;
        }

        private String lastName;

        String setLastName() {
            return lastName;
        }

        String getLastName() {
            return lastName;
        }

        private int age;

        int getAge() {
            return age;
        }

        int setAge() {
            return age;
        }

        private String homeTown;

        String setHomeTown() {
            return homeTown;
        }

        String getHomeTown() {
            return homeTown;
        }

        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public Student() {
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] info = input.split("\\s+");
            Student student = new Student(info[0], info[1], Integer.parseInt(info[2]), info[3]);
            students.add(student);
            input = scan.nextLine();
        }
        String command = scan.nextLine();
        for (Student student : students) {
            if (command.equals(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
}
