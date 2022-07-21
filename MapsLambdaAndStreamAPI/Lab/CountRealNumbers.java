package MapsLambdaAndStreamAPI.Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Double> numbers = Arrays.stream(scan.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
        Map<Double, Integer> numberOccurrences = new TreeMap<>();
        for (Double number : numbers) {
            Integer currentCount = numberOccurrences.get(number);
            if (currentCount == null) {
                numberOccurrences.put(number, 1);
            } else {
                numberOccurrences.put(number, currentCount + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numberOccurrences.entrySet()) {
            System.out.printf("%s -> %d%n", new DecimalFormat("#.#####").format(entry.getKey()), entry.getValue());
        }
    }
}
