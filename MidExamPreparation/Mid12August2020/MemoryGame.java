package MidExamPreparation.Mid12August2020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> board = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        int moves = 0;
        boolean hasWon = false;
        String input = scan.nextLine();
        while (!"end".equals(input)) {
            moves++;
            int[] indices = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int index1 = indices[0];
            int index2 = indices[1];
            if (validIndex(index1, board) && validIndex(index2, board) && index1 != index2) {
                String firstElement = board.get(index1);
                String secondElement = board.get(index2);
                if (firstElement.equals(secondElement)) {
                    board.remove(firstElement);
                    board.remove(secondElement);
                    System.out.println("Congrats! You have found matching elements - " + firstElement + "!");
                } else {
                    System.out.println("Try again!");
                }
            } else {
                board.add(board.size() / 2, "-" + moves + "a");
                board.add(board.size() / 2 + 1, "-" + moves + "a");
                System.out.println("Invalid input! Adding additional elements to the board");
            }
            if (board.size() == 0) {
                hasWon = true;
                break;
            }
            input = scan.nextLine();
        }

        if (hasWon) {
            System.out.println("You have won in " + moves + " turns!");
        } else {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", board));
        }
    }

    public static boolean validIndex(int index, List<String> list) {
        return 0 <= index && index < list.size();
    }
}
