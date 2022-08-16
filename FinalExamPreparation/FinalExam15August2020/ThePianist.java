package FinalExamPreparation.FinalExam15August2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ThePianist {
    public static class Piece {
        private String name;
        private String composer;
        private String key;

        public Piece(String name, String composer, String key) {
            this.name = name;
            this.composer = composer;
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public String getComposer() {
            return composer;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Piece> pieces = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            Piece piece = new Piece(input[0], input[1], input[2]);
            pieces.put(input[0], piece);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Add":
                    if (pieces.containsKey(command[1])) {
                        System.out.printf("%s is already in the collection!%n", command[1]);
                    } else {
                        Piece piece = new Piece(command[1], command[2], command[3]);
                        pieces.put(command[1], piece);
                        System.out.printf("%s by %s in %s added to the collection!%n", command[1], command[2], command[3]);
                    }
                    break;
                case "Remove":
                    if (pieces.containsKey(command[1])) {
                        pieces.remove(command[1]);
                        System.out.printf("Successfully removed %s!%n", command[1]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
                case "ChangeKey":
                    if (pieces.containsKey(command[1])) {
                        pieces.get(command[1]).setKey(command[2]);
                        System.out.printf("Changed the key of %s to %s!%n", command[1], command[2]);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
            }

            input = scan.nextLine();
        }
        pieces.values().forEach(piece -> System.out.printf("%s -> Composer: %s, Key: %s%n", piece.getName(), piece.getComposer(), piece.getKey()));
    }
}
