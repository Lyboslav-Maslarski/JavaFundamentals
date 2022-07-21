package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int hour = Integer.parseInt(scan.nextLine());
        int min = Integer.parseInt(scan.nextLine());
        int newMin=min+30;
        if (newMin>59){
            hour++;
            newMin-=60;
        }
        if (hour==24){
            hour=0;
        }
        System.out.printf("%d:%02d",hour,newMin);
    }
}
