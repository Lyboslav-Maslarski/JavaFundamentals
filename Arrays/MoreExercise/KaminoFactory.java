package Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        String input = scan.nextLine();
        int maxCount = 0;
        int maxIndex = 0;
        int maxSum = 0;
        int[] maxDNA = new int[length];
        int arrayCount = 0;
        int maxArrayCount = 0;
        while (!input.equals("Clone them!")) {
            int[] DNA = Arrays.stream(input.split("!+")).mapToInt(Integer::parseInt).toArray();
            arrayCount++;
            int currentMaxCount = 0;
            int currentMaxIndex = 0;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                int counter = 0;
                if (DNA[i] == 1) {
                    sum++;
                    for (int j = i + 1; j < length; j++) {
                        if (DNA[j] == 1) {
                            counter++;
                        } else {
                            if (counter > currentMaxCount) {
                                currentMaxCount = counter;
                                currentMaxIndex = i;
                            }
                            break;
                        }
                    }
                }
            }
            if (currentMaxCount > maxCount) {
                maxCount = currentMaxCount;
                maxIndex = currentMaxIndex;
                maxSum = sum;
                maxDNA = DNA;
                maxArrayCount = arrayCount;
            } else if (currentMaxCount == maxCount && (currentMaxIndex < maxIndex || sum > maxSum)) {
                maxCount = currentMaxCount;
                maxIndex = currentMaxIndex;
                maxSum = sum;
                maxDNA = DNA;
                maxArrayCount = arrayCount;
            } else if (arrayCount == 1) {
                maxCount = currentMaxCount;
                maxIndex = currentMaxIndex;
                maxSum = sum;
                maxDNA = DNA;
                maxArrayCount = arrayCount;
            }


            input = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.\n", maxArrayCount, maxSum);
        Arrays.stream(maxDNA).forEach(value -> System.out.printf("%d ", value));
    }
}
