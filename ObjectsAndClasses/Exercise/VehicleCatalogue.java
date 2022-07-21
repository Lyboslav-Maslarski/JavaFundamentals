package ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {
    static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int horsepower;

        public String getType() {
            return type;
        }

        public String getModel() {
            return model;
        }

        public String getColor() {
            return color;
        }

        public int getHorsepower() {
            return horsepower;
        }

        public Vehicle(String type, String model, String color, int horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }


    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] vehicleInfo = input.split("\\s+");
            String type = vehicleInfo[0].substring(0, 1).toUpperCase() + vehicleInfo[0].substring(1);
            String model = vehicleInfo[1];
            String color = vehicleInfo[2];
            int horsepower = Integer.parseInt(vehicleInfo[3]);
            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);
            input = scan.nextLine();
        }
        String input2 = scan.nextLine();
        while (!input2.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(input2)) {
                    System.out.printf("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d%n", vehicle.getType(), vehicle.getModel(),
                            vehicle.getColor(), vehicle.getHorsepower());
                }
            }
            input2 = scan.nextLine();
        }
        int carSum = 0;
        int carCount = 0;
        int truckSum = 0;
        int truckCount = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals("Car")) {
                carSum += vehicle.getHorsepower();
                carCount++;
            } else {
                truckSum += vehicle.getHorsepower();
                truckCount++;
            }
        }
        double avgCarHorsepower = carSum * 1.0 / carCount;
        double avgTruckHorsepower = truckSum * 1.0 / truckCount;
        if (carCount == 0) {
            avgCarHorsepower = 0;
        } else if (truckCount == 0) {
            avgTruckHorsepower = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", avgCarHorsepower);
        System.out.printf("Trucks have average horsepower of: %.2f.", avgTruckHorsepower);
    }
}
