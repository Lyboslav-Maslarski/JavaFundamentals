package MapsLambdaAndStreamAPI.Exercise;

import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<String>> companiesWithEmployees = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] data = input.split(" -> ");
            String companyName = data[0];
            String employeeID = data[1];
            if (companiesWithEmployees.get(companyName) != null && companiesWithEmployees.get(companyName).contains(employeeID)) {
                input = scan.nextLine();
                continue;
            }
            List<String> employees = new ArrayList<>();
            if (companiesWithEmployees.containsKey(companyName)) {
                employees = companiesWithEmployees.get(companyName);
            }
            employees.add(employeeID);
            companiesWithEmployees.put(companyName, employees);
            input = scan.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : companiesWithEmployees.entrySet()) {
            System.out.println(entry.getKey());
            companiesWithEmployees.get(entry.getKey()).forEach(s -> System.out.println("-- " + s));
        }
    }
}
