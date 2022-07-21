package MapsLambdaAndStreamAPI.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();

        String resource = scan.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scan.nextLine());
            if (resources.get(resource) == null) {
                resources.put(resource, quantity);
            } else {
                int gathered = resources.get(resource);
                resources.put(resource, gathered + quantity);
            }
            resource = scan.nextLine();
        }
        resources.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
