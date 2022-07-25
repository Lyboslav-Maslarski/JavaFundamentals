package FinalExamPreparation.FinalExam10April2020;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String massage = scan.nextLine();
        String[] command = scan.nextLine().split(":\\|:");
        while (!command[0].equals("Reveal")) {
            switch (command[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(command[1]);
                    massage = massage.substring(0, index) + " " + massage.substring(index);
                    break;
                case "Reverse":
                    if (massage.contains(command[1])) {
                        index = massage.indexOf(command[1]);
                        StringBuilder toReverse = new StringBuilder(massage.substring(index, index + command[1].length()));
                        massage = massage.substring(0, index) + massage.substring(index + command[1].length()) + toReverse.reverse();
                    } else {
                        System.out.println("error");
                        command = scan.nextLine().split(":\\|:");
                        continue;
                    }
                    break;
                case "ChangeAll":
                    massage = massage.replace(command[1], command[2]);
                    break;
            }
            System.out.println(massage);
            command = scan.nextLine().split(":\\|:");
        }
        System.out.println("You have a new text message: " + massage);
    }
}
