package apr25.Assignment;

import java.util.Scanner;

public class AsgY2G2_Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AsgY2G2_ToyCar car = new AsgY2G2_ToyCar();

        System.out.println("Initial status of the toy car:\n");
        System.out.print(car);

        while (true) {
            System.out.println("Controlling menu:\n=================");
            System.out.println("""
                1. on the car
                2. off the car
                3. move forward
                4. move backward
                5. turn left
                6. turn right
                7. stop the car
            """);
            try {
                System.out.print("Enter the menu number (1 to 7), 0 to quit: ");
                int choice = Integer.parseInt(input.nextLine());
                System.out.println();
                switch (choice) {
                    case 1 -> car.on();
                    case 2 -> car.off();
                    case 3 -> car.forward();
                    case 4 -> car.backward();
                    case 5 -> car.turnLeft();
                    case 6 -> car.turnRight();
                    case 7 -> car.stop();
                    case 0 -> {
                        System.out.println("System ended.");
                        return;
                    }
                    default -> {
                        System.out.println("Invalid action. Enter a number between 0 and 7.\n");
                        continue;
                    }
                }
                System.out.println("Action complete.\n");
                System.out.print(car);
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid action. Please input only the number of the menu.\n");
            } catch (Exception e) {
                System.out.println("Invalid action.\n" + e.getMessage() + "\n");
            }
        }
    }
}
