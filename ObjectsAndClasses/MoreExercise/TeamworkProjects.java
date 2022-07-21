package ObjectsAndClasses.MoreExercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeamworkProjects {
    static class Team {
        String name;
        String creator;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getMembers() {
            return members;
        }

        public void setMembers(List<String> members) {
            this.members = members;
        }

        public Team(String name, String creator) {
            this.name = name;
            this.creator = creator;
        }

        List<String> members = new ArrayList<>();

         int getMembersSize() {
            return members.size();
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Team> teamList = new ArrayList<>();
        List<String> teamNames = new ArrayList<>();
        List<String> creators = new ArrayList<>();
        int n = Integer.parseInt(scan.nextLine());
        while (n-- > 0) {
            String[] data = scan.nextLine().split("-");
            if (teamNames.contains(data[1])) {
                System.out.printf("Team %s was already created!%n", data[1]);
            } else if (creators.contains(data[0])) {
                System.out.printf("%s cannot create another team!%n", data[0]);
            } else {
                Team team = new Team(data[1], data[0]);
                teamList.add(team);
                teamNames.add(data[1]);
                creators.add(data[0]);
                System.out.printf("Team %s has been created by %s!%n", data[1], data[0]);
            }
        }
        String[] input = scan.nextLine().split("->");
        while (!input[0].equals("end of assignment")) {
            if (!teamNames.contains(input[1])) {
                System.out.printf("Team %s does not exist!%n", input[1]);
            } else {
                boolean newMember = true;
                for (Team team : teamList) {
                    if (team.getMembers().contains(input[0]) || team.getCreator().equals(input[0])) {
                        newMember = false;
                        break;
                    }
                }
                if (newMember) {
                    int index = teamNames.indexOf(input[1]);
                    Team team = teamList.get(index);
                    team.getMembers().add(input[0]);
                } else {
                    System.out.printf("Member %s cannot join team %s!%n", input[0], input[1]);
                }
            }
            input = scan.nextLine().split("->");
        }
        teamList.sort(Comparator.comparing(Team::getName));
        teamList.sort(Comparator.comparing(Team::getMembersSize).reversed());
        teamList.stream().filter(team -> team.getMembers().size() != 0).forEach(team -> {
            System.out.printf("%s%n- %s%n", team.getName(), team.getCreator());
            team.getMembers().sort(String::compareTo);
            team.getMembers().forEach(member -> System.out.printf("-- %s%n", member));
        });
        System.out.println("Teams to disband:");
        teamList.stream().sorted(Comparator.comparing(Team::getName)).filter(team -> team.getMembers().size() == 0)
                .forEach(team -> System.out.printf("%s%n", team.getName()));
    }
}

