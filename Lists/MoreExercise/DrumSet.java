package Lists.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DrumSet {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double savings = Double.parseDouble(scan.nextLine());
        List<Integer> initialDrums = Arrays.stream(scan.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drums = new ArrayList<>(initialDrums);
        String input = scan.nextLine();
        while (!input.equals("Hit it again, Gabsy!")) {
            int hitPower = Integer.parseInt(input);
            for (int i = 0; i < drums.size(); i++) {
                int currentDrum = drums.get(i);
                if (currentDrum > hitPower) {
                    drums.set(i, currentDrum - hitPower);
                } else {
                    if (savings >= initialDrums.get(i) * 3) {
                        drums.set(i, initialDrums.get(i));
                        savings -= initialDrums.get(i) * 3;
                    } else {
                        drums.set(i, 0);
                    }
                }
            }
            input = scan.nextLine();
        }
        drums.forEach(e -> {
            if (e > 0) {
                System.out.print(e + " ");
            }
        });
        System.out.println();
        System.out.printf("Gabsy has %.2flv.", savings);
    }
}
