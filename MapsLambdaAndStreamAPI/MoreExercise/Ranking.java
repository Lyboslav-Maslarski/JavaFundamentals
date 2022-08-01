package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static class User {
        String name;
        Map<String, Integer> contestsWithPoints;

        public User(String name, Map<String, Integer> contestsWithPoints) {
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
        Map<String, String> contestsWithPasswords = new HashMap<>();
        String[] input = scan.nextLine().split(":");
        while (!input[0].equals("end of contests")) {
            contestsWithPasswords.put(input[0], input[1]);
            input = scan.nextLine().split(":");
        }
        Map<String, User> users = new TreeMap<>();
        input = scan.nextLine().split("=>");
        while (!input[0].equals("end of submissions")) {
            String contestName = input[0];
            String contestPassword = input[1];
            String userName = input[2];
            int userPoints = Integer.parseInt(input[3]);
            if (contestsWithPasswords.containsKey(contestName) && contestsWithPasswords.get(contestName).equals(contestPassword)) {
                users.putIfAbsent(userName, new User(userName, new HashMap<>()));
                users.get(userName).getContestsWithPoints().putIfAbsent(contestName, userPoints);
                if (users.get(userName).getContestsWithPoints().get(contestName) < userPoints) {
                    users.get(userName).getContestsWithPoints().put(contestName, userPoints);
                }
            }
            input = scan.nextLine().split("=>");
        }
        int maxPoints = 0;
        String maxPointsUser = "";
        for (User user : users.values()) {
            int currentPoints = user.getContestsWithPoints().values().stream().mapToInt(e -> e).sum();
            if (currentPoints > maxPoints) {
                maxPoints = currentPoints;
                maxPointsUser = user.getName();
            }
        }
        System.out.printf("Best candidate is %s with total %d points.%n", maxPointsUser, maxPoints);
        System.out.println("Ranking:");
        for (User user : users.values()) {
            System.out.println(user.getName());
            user.getContestsWithPoints().entrySet().stream().sorted((v1, v2) -> Integer.compare(v2.getValue(), v1.getValue()))
                    .forEach(contest -> System.out.printf("#  %s -> %d%n", contest.getKey(), contest.getValue()));
        }
    }
}
