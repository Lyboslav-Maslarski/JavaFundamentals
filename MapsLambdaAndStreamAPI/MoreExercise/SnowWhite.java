package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> dwarfs = new LinkedHashMap<>();
        Map<String, Integer> dwarfCountByColor = new LinkedHashMap<>();
        String input;

        while (!"Once upon a time".equals(input = scanner.nextLine())) {

            String[] lineInput = input.split(" <:> ");

            String dwarf = lineInput[1] + " " + lineInput[0];
            String color = lineInput[1];
            int physics = Integer.parseInt(lineInput[2]);

            dwarfCountByColor.putIfAbsent(color, 0);
            dwarfCountByColor.put(color, dwarfCountByColor.get(color) + 1);

            if (dwarfs.containsKey(dwarf)) {
                if (dwarfs.get(dwarf) < physics) {
                    dwarfs.put(dwarf, physics);
                    dwarfCountByColor.put(color, dwarfCountByColor.get(color) - 1);
                }
            }else {
                dwarfs.put(dwarf, physics);
            }
        }

        dwarfs.entrySet().stream().sorted((pair1, pair2) -> {
            int sort = Integer.compare(pair2.getValue(), pair1.getValue());
            if (sort == 0) {

                String[] color1 = pair1.getKey().split(" ");
                String[] color2 = pair2.getKey().split(" ");

                int size1 = dwarfCountByColor.get(color1[0]);
                int size2 = dwarfCountByColor.get(color2[0]);
                sort = Integer.compare(size2, size1);
            }
            return sort;
        }).forEach(pair -> {
            String[] print = pair.getKey().split(" ");
            System.out.printf("(%s) %s <-> %d\n", print[0], print[1], pair.getValue());
        });

    }
}