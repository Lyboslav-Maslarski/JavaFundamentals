package ObjectsAndClasses.MoreExercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        List<Tire> tires;

        public Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tires = tires;
        }

        public String getModel() {
            return model;
        }
    }

    public static class Engine {
        int engineSpeed;
        int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }

        public int getEnginePower() {
            return enginePower;
        }
    }

    public static class Cargo {
        int cargoWeight;
        String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }

        public String getCargoType() {
            return cargoType;
        }
    }

    public static class Tire {
        double tirePressure;
        int tireAge;

        public Tire(double tirePressure, int tireAge) {
            this.tirePressure = tirePressure;
            this.tireAge = tireAge;
        }

        public double getTirePressure() {
            return tirePressure;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Car> cars = new LinkedList<>();
        int n = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            String model = input[0];
            int engineSpeed = Integer.parseInt(input[1]);
            int enginePower = Integer.parseInt(input[2]);
            int cargoWeight = Integer.parseInt(input[3]);
            String cargoType = input[4];
            List<Tire> tires = new ArrayList<>();
            for (int j = 5; j < input.length; j += 2) {
                double tirePressure = Double.parseDouble(input[j]);
                int tireAge = Integer.parseInt(input[j + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }
            Car car = new Car(model, new Engine(engineSpeed, enginePower), new Cargo(cargoWeight, cargoType), tires);
            cars.add(car);
        }
        String input = scan.nextLine();
        if (input.equals("fragile")) {
            cars.forEach(car -> {
                if (car.cargo.getCargoType().equals("fragile")) {
                    boolean hasSuitableTires = false;
                    for (Tire tire : car.tires) {
                        if (tire.getTirePressure() < 1) {
                            hasSuitableTires = true;
                            break;
                        }
                    }
                    if (hasSuitableTires) {
                        System.out.println(car.model);
                    }
                }
            });
        } else {
            cars.forEach(car -> {
                if (car.cargo.getCargoType().equals("flamable") && car.engine.getEnginePower() > 250) {
                    System.out.println(car.model);
                }
            });
        }
    }
}
