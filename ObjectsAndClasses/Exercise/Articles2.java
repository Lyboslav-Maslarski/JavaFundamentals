package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles2 {
    static class Article {
        public String getTitle() {
            return title;
        }

        private String title;

        public String getContent() {
            return content;
        }

        private String content;

        public String getAuthor() {
            return author;
        }

        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Article> articles = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(", ");
            Article article = new Article(input[0], input[1], input[2]);
            articles.add(article);
        }
        articles.forEach(article -> System.out.println(article.getTitle() + " - " + article.getContent() + ": " + article.getAuthor()));
    }
}
