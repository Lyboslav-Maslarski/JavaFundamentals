package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class Judge {
    public static class Student {
        String name;
        Map<String, Integer> contestsWithPoints;

        public Student(String name, Map<String, Integer> contestsWithPoints) {
            this.name = name;
            this.contestsWithPoints = contestsWithPoints;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getContestsWithPoints() {
            return contestsWithPoints;
        }

        public void setContestsWithPoints(Map<String, Integer> contestsWithPoints) {
            this.contestsWithPoints = contestsWithPoints;
        }

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Student>> contestsWithStudents = new LinkedHashMap<>();
        Map<String, Student> students = new TreeMap<>();
        String[] input = scan.nextLine().split(" -> ");
        while (!input[0].equals("no more time")) {
            String userName = input[0];
            String contestName = input[1];
            int points = Integer.parseInt(input[2]);
            students.putIfAbsent(userName, new Student(userName, new TreeMap<>()));
            Student student = students.get(userName);
            student.getContestsWithPoints().putIfAbsent(contestName, 0);
            student.getContestsWithPoints().put(contestName, Math.max(points, student.getContestsWithPoints().get(contestName)));
            contestsWithStudents.putIfAbsent(contestName, new ArrayList<>());
            if (!contestsWithStudents.get(contestName).contains(student)) {
                contestsWithStudents.get(contestName).add(student);
            }
            input = scan.nextLine().split(" -> ");
        }
        for (Map.Entry<String, List<Student>> entry : contestsWithStudents.entrySet()) {
            System.out.printf("%s: %d participants%n", entry.getKey(), entry.getValue().size());
            entry.getValue().sort(Comparator.comparing(Student::getName));
            entry.getValue().sort((s1, s2) -> Integer.compare(s2.getContestsWithPoints().get(entry.getKey()), s1.getContestsWithPoints().get(entry.getKey())));
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.printf("%d. %s <::> %d%n", i + 1, entry.getValue().get(i).getName(), entry.getValue().get(i).getContestsWithPoints().get(entry.getKey()));
            }
        }
        System.out.println("Individual standings:");
        final int[] i = {1};
        students.values().stream().sorted((s1, s2) -> Integer.compare
                        (s2.getContestsWithPoints().values().stream().mapToInt(e -> e).sum(), s1.getContestsWithPoints().values().stream().mapToInt(e -> e).sum()))
                .forEach(student -> {
                    System.out.printf("%d. %s -> %d%n", i[0], student.getName(), student.getContestsWithPoints().values().stream().mapToInt(e -> e).sum());
                    i[0]++;
                });
    }
}
