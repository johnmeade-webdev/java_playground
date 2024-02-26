package loops;

import java.util.Scanner;

public class GrossPayInputValidation {

    public static void main(String[] args) {

        double rate = 15;
        double maxHours = 40;

        System.out.println("How many hours did you work this week?");
        Scanner scanner = new Scanner(System.in);
        double hoursWorked = scanner.nextDouble();

        while (hoursWorked < 0 || hoursWorked > 40) {
            System.out.println("Invalid entry. Your hours must be between 0 and 40 hours.");
            hoursWorked = scanner.nextDouble();
        }

        double grossPay = hoursWorked * rate;
        System.out.println("Your gross pay for " + hoursWorked + " hours worked is: " + "$" + grossPay);

        scanner.close();
    }
}
