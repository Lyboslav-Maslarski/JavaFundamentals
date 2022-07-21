package ObjectsAndClasses.Exercise;

import java.util.Scanner;

public class Articles {
    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void edit(String content) {
            this.content = content;
        }

        void changeAuthor(String author) {
            this.author = author;
        }

        void rename(String newTitle) {
            this.title = newTitle;
        }

        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] info = scan.nextLine().split(",\\s+");
        Article article = new Article(info[0], info[1], info[2]);
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(": ");
            switch (input[0]) {
                case "Edit":
                    article.edit(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.rename(input[1]);
                    break;
            }
        }
        System.out.println(article.toString());
    }
}
