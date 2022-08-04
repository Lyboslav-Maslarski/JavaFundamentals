package ObjectsAndClasses.MoreExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static class Car {
        String model;
        Engine engine;
        String weight;
        String color;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String toString() {
            return String.format("%s:%n%s Weight: %s%n Color: %s", this.model, this.engine, this.weight, this.color);
        }
    }

    public static class Engine {
        String model;
        int power;
        String displacement;
        String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
        }

        public String getModel() {
            return model;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }

        public String toString() {
            return String.format(" %s:%n   Power: %d%n   Displacement: %s%n   Efficiency: %s%n", this.model, this.power, this.displacement, this.efficiency);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        List<Engine> engines = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(" ");
            Engine engine = new Engine(input[0], Integer.parseInt(input[1]));
            if (input.length == 4) {
                engine.setDisplacement(input[2]);
                engine.setEfficiency(input[3]);
            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    engine.setDisplacement(input[2]);
                    engine.setEfficiency("n/a");
                } else {
                    engine.setDisplacement("n/a");
                    engine.setEfficiency(input[2]);
                }
            } else {
                engine.setDisplacement("n/a");
                engine.setEfficiency("n/a");
            }
            engines.add(engine);
        }
        int m = Integer.parseInt(scan.nextLine());
        List<Car> cars = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            String[] input = scan.nextLine().split(" ");
            Engine currentEngine = null;
            for (Engine engine : engines) {
                if (engine.getModel().equals(input[1])) {
                    currentEngine = engine;
                }
            }
            Car car = new Car(input[0], currentEngine);
            if (input.length == 4) {
                car.setWeight(input[2]);
                car.setColor(input[3]);
            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    car.setWeight(input[2]);
                    car.setColor("n/a");
                } else {
                    car.setWeight("n/a");
                    car.setColor(input[2]);
                }
            } else {
                car.setWeight("n/a");
                car.setColor("n/a");
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}
