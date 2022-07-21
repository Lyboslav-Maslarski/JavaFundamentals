package MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Double>> studentsWithGrades = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String studentName = scan.nextLine();
            double grade = Double.parseDouble(scan.nextLine());
            List<Double> grades = new ArrayList<>();
            if (studentsWithGrades.containsKey(studentName)) {
                grades = studentsWithGrades.get(studentName);
            }
            grades.add(grade);
            studentsWithGrades.put(studentName, grades);
        }
        studentsWithGrades.entrySet().stream()
                .filter(entry -> entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >= 4.5)
                .forEach(entry -> System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble()));
    }
}
