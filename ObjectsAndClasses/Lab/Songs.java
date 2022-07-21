package ObjectsAndClasses.Lab;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        private String typeList;

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getTypeList() {
            return typeList;
        }

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String duration;

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getDuration() {
            return duration;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] info = scan.nextLine().split("\\_");
            String type = info[0];
            String name = info[1];
            String duration = info[2];
            Song song = new Song();
            song.setTypeList(type);
            song.setName(name);
            song.setDuration(duration);
            songs.add(song);
        }
        String command= scan.nextLine();
        if (command.equals("all")){
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        }else {
            for (Song song : songs) {
                if (command.equals(song.getTypeList())){
                    System.out.println(song.getName());
                }
            }
        }
    }
}
