package FinalExamPreparation.FinalExam15August2020;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scan.nextLine());

        String command = scan.nextLine();
        while (!command.equals("Decode")) {
            String[] commands = command.split("\\|");
            switch (commands[0]) {
                case "Move":
                    int count = Integer.parseInt(commands[1]);
                    if (count >= 0 && count < input.length()) {
                        String subStr = input.substring(0, count);
                        input.replace(0, count, "");
                        input.append(subStr);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index <= input.length()) {
                        input.insert(index, commands[2]);
                    }
                    break;
                case "ChangeAll":
                    int searchIndex = input.indexOf(commands[1]);
                    while (searchIndex != -1) {
                        input.replace(0, input.length(), input.toString().replace(commands[1], commands[2]));
                        searchIndex = input.indexOf(commands[1]);
                    }
                    break;
                default:
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println("The decrypted message is: " + input);
    }
}
