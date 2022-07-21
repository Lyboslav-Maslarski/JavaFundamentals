package ObjectsAndClasses.MoreExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CompanyRoster {
    static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email = "n/a";
        private int age = -1;

        Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;

        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getPosition() {
            return position;
        }

        public String getDepartment() {
            return department;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    static class Department {
        String name;
        List<Employee> employeeList;
        double avgSalary;

        public String getName() {
            return name;
        }

        public List<Employee> getEmployeeList() {
            return employeeList;
        }

        public double getAvgSalary() {
            return avgSalary;
        }

        public Department(String name, List<Employee> employeeList) {
            this.name = name;
            this.employeeList = employeeList;
            this.avgSalary = employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Employee> employeeList = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");
            Employee employee = new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]);
            if (input.length == 6) {
                employee.setEmail(input[4]);
                employee.setAge(Integer.parseInt(input[5]));
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    employee.setEmail(input[4]);
                } else {
                    employee.setAge(Integer.parseInt(input[4]));
                }
            }
            employeeList.add(employee);
        }
        List<String> departmentsList = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
        List<Department> departments = new ArrayList<>();
        for (String department : departmentsList) {
            departments.add(new Department(department, employeeList.stream().filter
                    (employee -> employee.getDepartment().equals(department)).collect(Collectors.toList())));
        }
            departments.sort(Comparator.comparingDouble(Department::getAvgSalary).reversed());
            Department department1=departments.get(0);
            department1.getEmployeeList().sort(Comparator.comparingDouble(Employee::getSalary).reversed());
            System.out.printf("Highest Average Salary: %s%n", department1.getName());
            for (Employee employee : department1.getEmployeeList()) {
                System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());
            }
        }
    }

