package MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] userInfo = scan.nextLine().split("\\s+");
            if (userInfo[0].equals("register")) {
                if (users.containsKey(userInfo[1])) {
                    System.out.println("ERROR: already registered with plate number " + users.get(userInfo[1]));
                } else {
                    users.put(userInfo[1], userInfo[2]);
                    System.out.println(userInfo[1] + " registered " + userInfo[2] + " successfully");
                }
            } else {
                if (users.containsKey(userInfo[1])) {
                    users.remove(userInfo[1]);
                    System.out.println(userInfo[1] + " unregistered successfully");
                } else {
                    System.out.println("ERROR: user " + userInfo[1] + " not found");
                }
            }
        }
        users.entrySet().forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));
    }
}
