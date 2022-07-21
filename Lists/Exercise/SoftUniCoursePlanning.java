package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> courses = Arrays.stream(scan.nextLine().split("\\,\\s+")).collect(Collectors.toList());
        String[] command = scan.nextLine().split("\\:");
        while (!command[0].equals("course start")) {

            switch (command[0]) {
                case "Add":
                    if (!courses.contains(command[1])) {
                        courses.add(command[1]);
                    }
                    break;
                case "Insert":
                    if (!courses.contains(command[1])) {
                        courses.add(Integer.parseInt(command[2]), command[1]);
                    }
                    break;
                case "Remove":
                    if (courses.contains(command[1])) {
                        courses.remove(command[1] + "-Exercise");
                        courses.remove(command[1]);
                    }
                    break;
                case "Swap":
                    if (courses.contains(command[1]) && courses.contains(command[2])) {
                        int index1 = courses.indexOf(command[1]);
                        int index2 = courses.indexOf(command[2]);
                        courses.set(index1, command[2]);
                        courses.set(index2, command[1]);
                        if (courses.contains(command[1] + "-Exercise")) {
                            courses.remove(command[1] + "-Exercise");
                            courses.add(index2 + 1, command[1] + "-Exercise");
                        }
                        if (courses.contains(command[2] + "-Exercise")) {
                            courses.remove(command[2] + "-Exercise");
                            courses.add(index1 + 1, command[2] + "-Exercise");
                        }
                    }
                    break;
                case "Exercise":
                    if (courses.contains(command[1]) && !courses.contains(command[1] + "-Exercise")) {
                        int index = courses.indexOf(command[1]);
                        courses.add(index + 1, command[1] + "-Exercise");
                    } else if (!courses.contains(command[1])) {
                        courses.add(command[1]);
                        courses.add(command[1] + "-Exercise");
                    }
                    break;
            }
            command = scan.nextLine().split("\\:");
        }
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + 1 + "." + courses.get(i));
        }
    }
}
