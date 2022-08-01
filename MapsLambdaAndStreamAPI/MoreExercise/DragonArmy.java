package MapsLambdaAndStreamAPI.MoreExercise;

import java.util.*;

public class DragonArmy {
    public static class Dragon {
        String name;
        int dmg;
        int health;
        int armor;

        public Dragon(String name, int dmg, int health, int armor) {
            this.name = name;
            this.dmg = dmg;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDmg() {
            return dmg;
        }

        public void setDmg(int dmg) {
            this.dmg = dmg;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, List<Dragon>> typeWithDragons = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String dragonType = input[0];
            String dragonName = input[1];
            int dragonDmg = input[2].equals("null") ? 45 : Integer.parseInt(input[2]);
            int dragonHealth = input[3].equals("null") ? 250 : Integer.parseInt(input[3]);
            int dragonArmor = input[4].equals("null") ? 10 : Integer.parseInt(input[4]);
            Dragon dragon = new Dragon(dragonName, dragonDmg, dragonHealth, dragonArmor);
            typeWithDragons.putIfAbsent(dragonType, new ArrayList<>());
            boolean isNewDragon = true;
            int index = 0;
            for (Dragon entry : typeWithDragons.get(dragonType)) {
                if (entry.getName().equals(dragonName)) {
                    isNewDragon = false;
                    index = typeWithDragons.get(dragonType).indexOf(entry);
                    break;
                }
            }
            if (isNewDragon) {
                typeWithDragons.get(dragonType).add(dragon);
            } else {
                Dragon currentDragon = typeWithDragons.get(dragonType).get(index);
                currentDragon.setDmg(dragonDmg);
                currentDragon.setHealth(dragonHealth);
                currentDragon.setArmor(dragonArmor);
            }
        }
        for (Map.Entry<String, List<Dragon>> entry : typeWithDragons.entrySet()) {
            double avgDmg = entry.getValue().stream().mapToInt(Dragon::getDmg).sum() * 1.0 / entry.getValue().size();
            double avgHealth = entry.getValue().stream().mapToInt(Dragon::getHealth).sum() * 1.0 / entry.getValue().size();
            double avgArmor = entry.getValue().stream().mapToInt(Dragon::getArmor).sum() * 1.0 / entry.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), avgDmg, avgHealth, avgArmor);
            entry.getValue().stream().sorted(Comparator.comparing(Dragon::getName))
                    .forEach(dragon -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragon.getName(), dragon.getDmg(), dragon.getHealth(), dragon.getArmor()));
        }
    }
}
