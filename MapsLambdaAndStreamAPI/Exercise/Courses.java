package MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> coursesWithStudents = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String courseName = data[0];
            String studentName = data[1];
            List<String> students = new ArrayList<>();
            if (coursesWithStudents.containsKey(courseName)) {
                students = coursesWithStudents.get(courseName);
            }
            students.add(studentName);
            coursesWithStudents.put(courseName, students);

            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : coursesWithStudents.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().forEach(s -> System.out.println("-- " + s));
        }
    }
}

