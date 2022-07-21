package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int ppl = Integer.parseInt(scan.nextLine());
        int elevator = Integer.parseInt(scan.nextLine());
        int courses = 0;
        if (ppl % elevator == 0) {
            courses = ppl / elevator;
        } else {
            courses = ppl / elevator + 1;
        }
        System.out.println(courses);
    }
}
