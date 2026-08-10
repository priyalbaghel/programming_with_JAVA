import java.util.Scanner;

interface Switchable {
    void turnOn();
}

class Light implements Switchable {
    public void turnOn() {
        System.out.println("Light is ON.");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan is ON.");
    }
}

public class SwitchDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Device");
        System.out.println("1. Light");
        System.out.println("2. Fan");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        Switchable device;

        if (choice == 1) {
            device = new Light();
        } else {
            device = new Fan();
        }

        device.turnOn();

        sc.close();
    }
}