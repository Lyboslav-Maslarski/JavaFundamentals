package Methods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] command = scan.nextLine().split(" ");
        while (!command[0].equals("end")) {
            switch (command[0]) {
                case "exchange":
                    exchange(numbers, command[1]);
                    break;
                case "max":
                    maxEvenOrOddNumberIndex(numbers, command[1]);
                    break;
                case "min":
                    minEvenOrOddNumberIndex(numbers, command[1]);
                    break;
                case "first":
                    printFirstCountElements(numbers, command[1], command[2]);
                    break;
                case "last":
                    printLastCountElements(numbers, command[1], command[2]);
                    break;
            }
            command = scan.nextLine().split(" ");
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static void printLastCountElements(int[] numbers, String s, String s1) {
        int count = Integer.parseInt(s);
        int[] numbersToPrint = new int[count];
        if (count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }
        int position = 0;
        if (s1.equals("even")) {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % 2 == 0) {
                    numbersToPrint[position] = numbers[i];
                    position++;
                    if (position == count) {
                        break;
                    }
                }
            }
        } else {
            for (int i = numbers.length - 1; i >= 0; i--) {
                if (numbers[i] % 2 != 0) {
                    numbersToPrint[position] = numbers[i];
                    position++;
                    if (position == count) {
                        break;
                    }
                }
            }
        }

        if (position == count) {
            for (int i = 0; i < numbersToPrint.length / 2; i++) {
                int temp = numbersToPrint[i];
                numbersToPrint[i] = numbersToPrint[numbersToPrint.length - 1 - i];
                numbersToPrint[numbersToPrint.length - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(numbersToPrint));
        } else {
            int[] array = new int[position];
            System.arraycopy(numbersToPrint, 0, array, 0, position);
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }

    private static void printFirstCountElements(int[] numbers, String s, String s1) {
        int count = Integer.parseInt(s);
        int[] numbersToPrint = new int[count];
        if (count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }
        int position = 0;
        if (s1.equals("even")) {
            for (int number : numbers) {
                if (number % 2 == 0) {
                    numbersToPrint[position] = number;
                    position++;
                    if (position == count) {
                        break;
                    }
                }
            }
        } else {
            for (int number : numbers) {
                if (number % 2 != 0) {
                    numbersToPrint[position] = number;
                    position++;
                    if (position == count) {
                        break;
                    }
                }
            }
        }
        if (position == count) {
            System.out.println(Arrays.toString(numbersToPrint));
        } else {
            int[] array = new int[position];
            System.arraycopy(numbersToPrint, 0, array, 0, position);
            System.out.println(Arrays.toString(array));
        }
    }

    private static void minEvenOrOddNumberIndex(int[] numbers, String s) {
        int minNumber = Integer.MAX_VALUE;
        int minNumberIndex = 0;
        if (s.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] <= minNumber) {
                        minNumber = numbers[i];
                        minNumberIndex = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    if (numbers[i] <= minNumber) {
                        minNumber = numbers[i];
                        minNumberIndex = i;
                    }
                }
            }
        }
        if (minNumber == Integer.MAX_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(minNumberIndex);
        }
    }

    private static void maxEvenOrOddNumberIndex(int[] numbers, String s) {
        int maxNumber = Integer.MIN_VALUE;
        int maxNumberIndex = 0;
        if (s.equals("even")) {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 == 0) {
                    if (numbers[i] >= maxNumber) {
                        maxNumber = numbers[i];
                        maxNumberIndex = i;
                    }
                }
            }
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    if (numbers[i] >= maxNumber) {
                        maxNumber = numbers[i];
                        maxNumberIndex = i;
                    }
                }
            }
        }
        if (maxNumber == Integer.MIN_VALUE) {
            System.out.println("No matches");
        } else {
            System.out.println(maxNumberIndex);
        }
    }

    private static void exchange(int[] numbers, String s) {
        int index = Integer.parseInt(s);
        if (index < 0 || index > numbers.length - 1) {
            System.out.println("Invalid index");
            return;
        }
        int[] a = Arrays.copyOfRange(numbers, 0, index + 1);
        int[] b = Arrays.copyOfRange(numbers, index + 1, numbers.length);
        System.arraycopy(b, 0, numbers, 0, b.length);
        System.arraycopy(a, 0, numbers, b.length, a.length);
    }
}
