package Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> train = new ArrayList<>();
        String[] line = scan.nextLine().split(" ");
        for (String s : line) {
            train.add(Integer.parseInt(s));
        }
        int wagonCapacity = Integer.parseInt(scan.nextLine());
        String[] command = scan.nextLine().split(" ");
        while (!command[0].equals("end")) {

            if ("Add".equals(command[0])) {
                train.add(Integer.parseInt(command[1]));
            }else {
                int passengers=Integer.parseInt(command[0]);
                for (int i = 0; i <train.size(); i++) {
                    if (train.get(i)+passengers<=wagonCapacity){
                        train.set(i,train.get(i)+passengers);
                        break;
                    }
                }
            }
            command = scan.nextLine().split(" ");
        }
        System.out.println(train.toString().replaceAll("[\\[\\],]",""));
    }
}
