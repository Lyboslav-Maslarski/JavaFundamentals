package MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class SoftUniExamResults {
    static class Student {
        String name;
        List<String> languages;
        int score;

        public Student(String name, List<String> languages, int score) {
            this.name = name;
            this.languages = languages;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getLanguages() {
            return languages;
        }

        public void setLanguages(List<String> languages) {
            this.languages = languages;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Student> students = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();
        List<String> bannedStudents = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("exam finished")) {
            String[] data = input.split("-");
            String name = data[0];
            if (input.contains("banned")) {
                bannedStudents.add(name);
            } else {
                if (!bannedStudents.contains(name)) {
                    String language = data[1];
                    int score = Integer.parseInt(data[2]);
                    students.putIfAbsent(name, new Student(name, new ArrayList<>(), 0));
                    students.get(name).getLanguages().add(language);
                    if (students.get(name).getScore() < score) {
                        students.get(name).setScore(score);
                    }
                    languages.putIfAbsent(language, 0);
                    languages.put(language, languages.get(language) + 1);
                }
            }
            input = scan.nextLine();
        }
        System.out.println("Results:");
        students.forEach((k, v) -> {
            if (!bannedStudents.contains(k)) {
                System.out.println(k + " | " + v.getScore());
            }
        });
        System.out.println("Submissions:");
        languages.forEach((k, v) -> System.out.println(k + " - " + v));
    }
}