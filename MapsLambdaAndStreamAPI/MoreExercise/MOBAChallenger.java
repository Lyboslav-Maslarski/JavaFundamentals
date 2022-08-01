package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class MOBAChallenger {
    public static class Player {
        String name;
        Map<String, Integer> positionsWithPoints;
        int totalPoints;

        public Player(String name, Map<String, Integer> positionsWithPoints) {
            this.name = name;
            this.positionsWithPoints = positionsWithPoints;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getPositionsWithPoints() {
            return positionsWithPoints;
        }

        public void setPositionsWithPoints(Map<String, Integer> positionsWithPoints) {
            this.positionsWithPoints = positionsWithPoints;
        }

        public void setTotalPoints() {
            this.totalPoints = this.positionsWithPoints.values().stream().mapToInt(value -> value).sum();
        }

        public int getTotalPoints() {
            return totalPoints;
        }
    }

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        List<String> playersAsStrings = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" -> ");
        while (!input[0].equals("Season end")) {

            if (input.length == 3) {
                String playerName = input[0];
                String playerPosition = input[1];
                int playerPoints = Integer.parseInt(input[2]);

                if (playersAsStrings.contains(playerName)) {
                    int index = playersAsStrings.indexOf(playerName);
                    Player player = players.get(index);
                    player.getPositionsWithPoints().putIfAbsent(playerPosition, 0);
                    player.getPositionsWithPoints().put(playerPosition, Math.max(playerPoints, player.getPositionsWithPoints().get(playerPosition)));
                } else {
                    playersAsStrings.add(playerName);
                    Player player = new Player(input[0], new TreeMap<>());
                    player.getPositionsWithPoints().put(playerPosition, playerPoints);
                    players.add(player);
                }
            } else {
                String[] duelPlayers = input[0].split(" vs ");
                String playerOne = duelPlayers[0];
                String playerTwo = duelPlayers[1];
                if (playersAsStrings.contains(playerOne) && playersAsStrings.contains(playerTwo)) {
                    Player player1 = players.get(playersAsStrings.indexOf(playerOne));
                    Player player2 = players.get(playersAsStrings.indexOf(playerTwo));
                    for (Map.Entry<String, Integer> position1 : player1.getPositionsWithPoints().entrySet()) {
                        boolean duelCompleted = false;
                        for (Map.Entry<String, Integer> position2 : player2.getPositionsWithPoints().entrySet()) {
                            if (position1.getKey().equals(position2.getKey())) {
                                int playerOneSkill = position1.getValue();
                                int playerTwoSkill = position2.getValue();
                                if (playerOneSkill > playerTwoSkill) {
                                    playersAsStrings.remove(playerTwo);
                                    players.remove(player2);
                                } else if (playerOneSkill < playerTwoSkill) {
                                    playersAsStrings.remove(playerOne);
                                    players.remove(player1);
                                }
                                duelCompleted = true;
                                break;
                            }
                        }
                        if (duelCompleted) {
                            break;
                        }
                    }
                }
            }
            input = scan.nextLine().split(" -> ");
        }
        players.sort(Comparator.comparing(Player::getName));
        players.sort((player1, player2) -> Integer.compare(player2.getPositionsWithPoints().values().stream().mapToInt(e -> e).sum(),
                player1.getPositionsWithPoints().values().stream().mapToInt(e -> e).sum()));
        players.forEach(player -> {
            System.out.printf("%s: %d skill%n", player.getName(), player.getPositionsWithPoints().values().stream().mapToInt(e -> e).sum());
            player.getPositionsWithPoints().entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue()))
                    .forEach(position -> System.out.printf("- %s <::> %d%n", position.getKey(), position.getValue()));
        });
    }
}
