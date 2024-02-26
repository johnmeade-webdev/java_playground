package methods;

import java.util.Scanner;

public class Greetings {

    public static void main(String[] args) {
        String name = getUserName();
        greetUser(name);
    }

    public static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.next();
        scanner.close();

        return name;
    }

    public static void greetUser(String name) {
        System.out.println("Hello, " + name + ". It's great to see you!");
    }
}
