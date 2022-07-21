package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class StudentInformation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        int age = scan.nextInt();
        double grade = scan.nextDouble();
        System.out.printf("Name: %s, Age: %d, Grade: %.2f", name, age, grade);
    }
}
