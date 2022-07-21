package MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class ForceBook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, List<String>> forcesWithMembers = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] data = input.split(" \\| ");
                String force = data[0];
                String user = data[1];
                if (forcesWithMembers.values().stream().anyMatch(list -> list.contains(user))) {
                    input = scan.nextLine();
                    continue;
                }
                forcesWithMembers.putIfAbsent(force, new ArrayList<>());
                forcesWithMembers.get(force).add(user);
            } else {
                String[] data = input.split(" -> ");
                String force = data[1];
                String user = data[0];
                forcesWithMembers.values().removeIf(v -> v.contains(user));
                forcesWithMembers.putIfAbsent(force, new ArrayList<>());
                forcesWithMembers.get(force).add(user);
                System.out.printf("%s joins the %s side!%n", user, force);
            }

            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : forcesWithMembers.entrySet()) {
            System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().forEach(s -> System.out.printf("! %s%n", s));
        }
    }
}
