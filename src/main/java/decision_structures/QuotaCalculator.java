package decision_structures;

import java.util.Scanner;

public class QuotaCalculator {

    public static void main(String[] args) {

        int quota = 10;

        System.out.println("Enter the number of sales made.");
        Scanner scanner = new Scanner(System.in);
        int sales = scanner.nextInt();

        if (sales >= quota) {
            System.out.println("Congrats! You've met your quota.");
        } else {
            int salesShort = quota - sales;
            System.out.println("You made " + sales + " sales. That is " + salesShort + " short of the quota." );
        }
        scanner.close();
    }
}
