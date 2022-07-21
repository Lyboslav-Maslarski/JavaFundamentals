package Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> distances = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (distances.size() > 0) {
            int index = Integer.parseInt(scan.nextLine());
            if (0 <= index && index < distances.size()) {
                sum += distances.get(index);
                for (int i = 0; i < distances.size(); i++) {
                    if (i == index) {
                        continue;
                    }
                    if (distances.get(i) <= distances.get(index)) {
                        distances.set(i, distances.get(i) + distances.get(index));
                    } else {
                        distances.set(i, distances.get(i) - distances.get(index));
                    }
                }
                distances.remove(index);
            } else if (index < 0) {
                index = 0;
                sum += distances.get(index);
                for (int i = 1; i < distances.size(); i++) {
                    if (distances.get(i) <= distances.get(index)) {
                        distances.set(i, distances.get(i) + distances.get(index));
                    } else {
                        distances.set(i, distances.get(i) - distances.get(index));
                    }
                }
                distances.set(0, distances.get(distances.size() - 1));
            } else {
                index = distances.size() - 1;
                sum += distances.get(index);
                for (int i = 0; i < distances.size() - 1; i++) {
                    if (distances.get(i) <= distances.get(index)) {
                        distances.set(i, distances.get(i) + distances.get(index));
                    } else {
                        distances.set(i, distances.get(i) - distances.get(index));
                    }
                }
                distances.set(distances.size() - 1, distances.get(0));
            }
        }
        System.out.println(sum);
    }
}
