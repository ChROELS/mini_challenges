package be.intecbrussel.katas;

import java.util.Scanner;

public class AskingUserYorN {
    public static void main(String[] args) {
    System.out.println("Would you like to add this person to the list? Y/N");
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
        while(flag) {
        String response = scanner.next().toUpperCase();
        switch (response) {
            case "Y":
                System.out.println("OK! I will proceed to the task!");
                flag = false;
                break;
            case "N":
                System.out.println("OK! I will do nothing!");
                flag = false;
                break;
            default:
                System.out.println("Please, enter Y for yes or N for no! Thank you!");
                break;
            }
        }
    }
}
