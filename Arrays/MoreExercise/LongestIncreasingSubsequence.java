package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split(" ")).mapToInt(value -> Integer.parseInt(value)).toArray();
        int[] sequanceLength = new int[array.length];
        int[] previous = new int[array.length];

        for (int i = 0; i < sequanceLength.length; i++) {
            sequanceLength[i] = 1;
            previous[i] = -1;
        }
        for (int currentIndex = 0; currentIndex < array.length; currentIndex++) {
            for (int previousIndex = 0; previousIndex < currentIndex; previousIndex++) {
                if (array[previousIndex] < array[currentIndex]) {
                    int candidateLength = sequanceLength[previousIndex] + 1;
                    if (candidateLength > sequanceLength[currentIndex]) {
                        sequanceLength[currentIndex] = candidateLength;
                        previous[currentIndex] = previousIndex;
                    }
                }
            }
        }
        int maxLength = 0;
        int maxLengthIndex = 0;
        for (int i = 0; i < sequanceLength.length; i++) {
            if (sequanceLength[i] > maxLength) {
                maxLength = sequanceLength[i];
                maxLengthIndex = i;
            }
        }
        int index = maxLengthIndex;
        int[] finalArray = new int[maxLength];
        int position = 0;
        while (index != -1) {
            finalArray[position] = array[index];
            position++;
            index = previous[index];
        }
        Arrays.sort(finalArray);
        Arrays.stream(finalArray).forEach(value -> System.out.print(value + " "));
    }
}
