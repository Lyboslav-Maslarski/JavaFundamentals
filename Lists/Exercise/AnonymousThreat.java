package Lists.Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> input = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] command = scan.nextLine().split("\\s+");
        while (!command[0].equals("3:1")) {
            if (command[0].equals("merge")) {
                int startIndex = Integer.parseInt(command[1]);
                int endIndex = Integer.parseInt(command[2]);
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > input.size() - 1) {
                    endIndex = input.size() - 1;
                }
                for (int i = 0; i < endIndex - startIndex; i++) {
                    input.set(startIndex, input.get(startIndex) + input.get(startIndex + 1));
                    input.remove(startIndex + 1);
                }
            } else {
                int index = Integer.parseInt(command[1]);
                int partitions = Integer.parseInt(command[2]);
                int length = input.get(index).length();
                String[] divided = new String[partitions];
                int dividedCount = 0;
                if (length % partitions == 0) {
                    for (int i = 0; i < length; i = i + length / partitions) {
                        String temp = input.get(index).substring(i, i + length / partitions);
                        divided[dividedCount] = temp;
                        dividedCount++;
                    }
                } else {
                    int partitionCounter = 0;
                    for (int i = 0; i < length; i += length / partitions) {
                        partitionCounter++;
                        String temp = "";
                        if (partitionCounter == partitions) {
                            temp = input.get(index).substring(i);
                            divided[dividedCount] = temp;
                            break;
                        } else {
                            temp = input.get(index).substring(i, i + length / partitions);
                            divided[dividedCount] = temp;
                            dividedCount++;
                        }
                    }
                }
                input.remove(index);
                for (int i = partitions - 1; i >= 0; i--) {
                    input.add(index, divided[i]);
                }
            }


            command = scan.nextLine().split("\\s+");
        }
        input.forEach(e -> System.out.printf("%s ", e));
    }
}
