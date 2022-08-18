package FinalExamPreparation.FinalExam10April2020;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeedIII {
    public static class Car {
        private String name;
        private int mileage;
        private int fuel;

        public Car(String name, int mileage, int fuel) {
            this.name = name;
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\|");
            Car car = new Car(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            cars.put(input[0], car);
        }
        String input = scan.nextLine();
        while (!input.equals("Stop")) {
            String[] command = input.split(" : ");
            if (command[0].equals("Drive")) {
                String carName = command[1];
                int distance = Integer.parseInt(command[2]);
                int fuel = Integer.parseInt(command[3]);
                if (cars.get(carName).getFuel() >= fuel) {
                    cars.get(carName).setMileage(cars.get(carName).getMileage() + distance);
                    cars.get(carName).setFuel(cars.get(carName).getFuel() - fuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carName, distance, fuel);
                    if (cars.get(carName).getMileage() >= 100000) {
                        cars.remove(carName);
                        System.out.printf("Time to sell the %s!%n", carName);
                    }
                } else {
                    System.out.println("Not enough fuel to make that ride");
                }
            } else if (command[0].equals("Refuel")) {
                String carName = command[1];
                int fuel = Integer.parseInt(command[2]);
                if (cars.get(carName).getFuel() + fuel > 75) {
                    fuel = 75- cars.get(carName).getFuel();
                    cars.get(carName).setFuel(75);
                } else {
                    cars.get(carName).setFuel(cars.get(carName).getFuel() + fuel);
                }
                System.out.printf("%s refueled with %d liters%n", carName, fuel);
            } else {
                String carName = command[1];
                int kilometers = Integer.parseInt(command[2]);
                if (cars.get(carName).getMileage() - kilometers >= 10000) {
                    cars.get(carName).setMileage(cars.get(carName).getMileage() - kilometers);
                    System.out.printf("%s mileage decreased by %d kilometers%n", carName, kilometers);
                } else {
                    cars.get(carName).setMileage(10000);
                }
            }
            input = scan.nextLine();
        }
        cars.values().forEach(car -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car.getName(), car.getMileage(), car.getFuel()));
    }
}
