package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge {
    static class Person {
        private String name;
        private String id;
        private int age;

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] personInfo = input.split("\\s+");
            String name = personInfo[0];
            String id = personInfo[1];
            int age = Integer.parseInt(personInfo[2]);
            Person person = new Person(name, id, age);
            people.add(person);
            input = scan.nextLine();
        }
        people.sort(Comparator.comparingInt(Person::getAge));
        people.forEach(person -> System.out.printf("%s with ID: %s is %d years old.%n", person.getName(), person.getId(), person.getAge()));
    }
}