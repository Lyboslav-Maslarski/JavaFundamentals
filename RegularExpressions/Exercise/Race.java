package RegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> players = Arrays.stream(scan.nextLine().split(", ")).collect(Collectors.toList());
        Map<String, Integer> playersDistance = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("end of race")) {
            String player = String.join("", input.split("[\\W\\d]"));
            if (players.contains(player)) {
                Pattern pattern = Pattern.compile("\\d");
                Matcher matcher = pattern.matcher(input);
                int sum = 0;
                while (matcher.find()) {
                    sum += Integer.parseInt(matcher.group());
                }
                playersDistance.putIfAbsent(player, 0);
                playersDistance.put(player, playersDistance.get(player) + sum);
            }
            input = scan.nextLine();
        }

        List<String> sorted = playersDistance.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).map(Map.Entry::getKey).collect(Collectors.toList());

        for (int i = 0; i < sorted.size(); i++) {
            if (i == 0) {
                System.out.println("1st place: " + sorted.get(0));
            } else if (i == 1) {
                System.out.println("2nd place: " + sorted.get(1));
            } else if (i == 2) {
                System.out.println("3rd place: " + sorted.get(2));
            }
        }
    }
}
