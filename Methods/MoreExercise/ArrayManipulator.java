package Methods.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] array = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String input = scan.nextLine();
        while (!input.equals("end")) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "exchange":
                    int index = Integer.parseInt(command[1]);
                    if (index < 0 || index >= array.length) {
                        System.out.println("Invalid index");
                        input = scan.nextLine();
                        continue;
                    }
                    int[] firstHalf = Arrays.copyOfRange(array, 0, index + 1);
                    int[] secondHalf = Arrays.copyOfRange(array, index + 1, array.length);
                    for (int i = 0; i < array.length; i++) {
                        if (i < secondHalf.length) {
                            array[i] = secondHalf[i];
                        } else {
                            array[i] = firstHalf[i - secondHalf.length];
                        }
                    }
                    break;
                case "max":
                    int maxNum = Integer.MIN_VALUE;
                    int maxNumIndex = -1;
                    if (command[1].equals("even")) {
                        for (int i = 0; i < array.length; i++) {
                            int num = array[i];
                            if (num % 2 == 0 && num >= maxNum) {
                                maxNum = num;
                                maxNumIndex = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < array.length; i++) {
                            int num = array[i];
                            if (num % 2 != 0 && num >= maxNum) {
                                maxNum = num;
                                maxNumIndex = i;
                            }
                        }
                    }
                    if (maxNumIndex < 0) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxNumIndex);
                    }
                    break;
                case "min":
                    int minNum = Integer.MAX_VALUE;
                    int minNumIndex = -1;
                    if (command[1].equals("even")) {
                        for (int i = 0; i < array.length; i++) {
                            int num = array[i];
                            if (num % 2 == 0 && num <= minNum) {
                                minNum = num;
                                minNumIndex = i;
                            }
                        }
                    } else {
                        for (int i = 0; i < array.length; i++) {
                            int num = array[i];
                            if (num % 2 != 0 && num <= minNum) {
                                minNum = num;
                                minNumIndex = i;
                            }
                        }
                    }
                    if (minNumIndex < 0) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minNumIndex);
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(command[1]);
                    if (countFirst > array.length) {
                        System.out.println("Invalid count");
                        input = scan.nextLine();
                        continue;
                    }
                    if (command[2].equals("even")) {
                        System.out.println(Arrays.toString(Arrays.stream(array).filter(value -> value % 2 == 0).limit(countFirst).toArray()));
                    } else {
                        System.out.println(Arrays.toString(Arrays.stream(array).filter(value -> value % 2 != 0).limit(countFirst).toArray()));
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(command[1]);
                    if (countLast > array.length) {
                        System.out.println("Invalid count");
                        input = scan.nextLine();
                        continue;
                    }
                    List<Integer> numbers = new ArrayList<>();
                    if (command[2].equals("even")) {
                        for (int i = array.length - 1; i >= 0; i--) {
                            if (array[i] % 2 == 0) {
                                numbers.add(array[i]);
                                countLast--;
                            }
                            if (countLast == 0) {
                                break;
                            }
                        }
                        System.out.println(numbers);
                    } else {
                        for (int i = array.length - 1; i >= 0; i--) {
                            if (array[i] % 2 != 0) {
                                numbers.add(array[i]);
                                countLast--;
                            }
                            if (countLast == 0) {
                                break;
                            }
                        }
                        System.out.println(numbers);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        System.out.println(Arrays.toString(array));
    }
}
