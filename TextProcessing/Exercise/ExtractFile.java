package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        int index1 = path.lastIndexOf('\\');
        int index2 = path.indexOf('.');
        System.out.println("File name: " + path.substring(index1 + 1, index2));
        System.out.println("File extension: " + path.substring(index2 + 1));
    }
}
