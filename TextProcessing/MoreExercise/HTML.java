package TextProcessing.MoreExercise;

import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String title = scan.nextLine();
        String article = scan.nextLine();
        System.out.println("<h1>");
        System.out.println(title);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println(article);
        System.out.println("</article>");
        String input = scan.nextLine();
        while (!input.equals("end of comments")) {
            System.out.println("<div>");
            System.out.println(input);
            System.out.println("</div>");
            input = scan.nextLine();
        }
    }
}
