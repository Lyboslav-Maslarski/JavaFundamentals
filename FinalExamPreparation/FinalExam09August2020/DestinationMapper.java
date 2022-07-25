package FinalExamPreparation.FinalExam09August2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> destinations = new ArrayList<>();
        int points = 0;
        String input = scan.nextLine();
        Pattern pattern = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            destinations.add(matcher.group("destination"));
            points += matcher.group("destination").length();
        }
        System.out.println("Destinations: " + String.join(", ", destinations));
        System.out.println("Travel Points: " + destinations.stream().mapToInt(String::length).sum());
    }
}
