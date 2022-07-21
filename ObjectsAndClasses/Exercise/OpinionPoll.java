package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OpinionPoll {
    static class Person {
        private String getName() {
            return name;
        }

        private String name;

        private int getAge() {
            return age;
        }

        private int age;

        private Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scan.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            Person person = new Person(name, age);
            personList.add(person);
        }
        for (Person person : personList) {
            if (person.getAge() > 30) {
                System.out.println(person.getName() + " - " + person.getAge());
            }
        }
    }
}
