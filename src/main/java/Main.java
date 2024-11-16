import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[] allCars = new Car[3];
        Car liderRace = null;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 4; i++) {
            System.out.println("— Введите название машины №" + i + ":");
            String nameCar = scanner.next();
            System.out.println("— Введите скорость машины №" + i + ":");
            double velocityCar = scanner.nextDouble();
            while (velocityCar < 0 || velocityCar > 250) {
                System.out.println("— Неправильная скорость");
                velocityCar = scanner.nextDouble();
            }
            allCars[i - 1] = new Car(nameCar, velocityCar);
            liderRace = new Race(allCars[i - 1],liderRace).findLider();
        }
        System.out.println("Самая быстрая машина: " + liderRace.name);
    }
}


class Car {
    String name;
    double velocity;
    Car(String name, double velocity){
        this.name = name;
        this.velocity = velocity;
    }
}
class Race {
    Car lider;
    Car carNow;
    Race(Car carNow,Car lider){
        this.carNow = carNow;
        this.lider = lider;
    }
    public Car findLider(){
        if (lider == null || lider.velocity < carNow.velocity){
            lider = carNow;
        }
        return lider;
    }

}
