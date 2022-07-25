package FinalExamPreparation.FinalExam4April2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    static class City {
        String name;
        int population;
        int gold;

        public City(String name, int population, int gold) {
            this.name = name;
            this.population = population;
            this.gold = gold;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulation() {
            return population;
        }

        public void setPopulation(int population) {
            this.population = population;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, City> cities = new LinkedHashMap<>();
        String input = scan.nextLine();
        while (!input.equals("Sail")) {
            String[] cityInfo = input.split("\\|\\|");
            if (cities.containsKey(cityInfo[0])) {
                cities.get(cityInfo[0]).setPopulation(cities.get(cityInfo[0]).getPopulation() + Integer.parseInt(cityInfo[1]));
                cities.get(cityInfo[0]).setGold(cities.get(cityInfo[0]).getGold() + Integer.parseInt(cityInfo[2]));
            } else {
                City city = new City(cityInfo[0], Integer.parseInt(cityInfo[1]), Integer.parseInt(cityInfo[2]));
                cities.putIfAbsent(cityInfo[0], city);
            }
            input = scan.nextLine();
        }
        input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split("=>");
            String currentCity = command[1];
            switch (command[0]) {
                case "Plunder":
                    int peopleKilled = Integer.parseInt(command[2]);
                    int stolenGold = Integer.parseInt(command[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", currentCity, stolenGold, peopleKilled);
                    int currentPopulation = cities.get(currentCity).getPopulation() - peopleKilled;
                    int currentGold = cities.get(currentCity).getGold() - stolenGold;
                    if (currentGold <= 0 || currentPopulation <= 0) {
                        System.out.println(currentCity + " has been wiped off the map!");
                        cities.remove(currentCity);
                    } else {
                        cities.get(currentCity).setPopulation(currentPopulation);
                        cities.get(currentCity).setGold(currentGold);
                    }
                    break;
                case "Prosper":
                    int goldToAdd = Integer.parseInt(command[2]);
                    if (goldToAdd < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        cities.get(currentCity).setGold(cities.get(currentCity).getGold() + goldToAdd);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToAdd, currentCity, cities.get(currentCity).getGold());
                    }
                    break;
            }
            input = scan.nextLine();
        }
        if (cities.size() > 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", cities.size());
            cities.values().forEach(city -> System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city.getName(), city.getPopulation(), city.getGold()));
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
