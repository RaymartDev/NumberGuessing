package me.raymart.dev;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to my number Guessing Game.");
        System.out.println("Please pick the maximum number to guess.");

        String input = scanner.nextLine();
        while (!isInt(input)) {
            System.out.println("Invalid input, please pick any number");
            input = scanner.nextLine();
        }

        int playerInput = Integer.parseInt(input);

        Game game = new Game(playerInput, scanner);
        game.start();
    }

    private static boolean isInt(String text) {
        try{
            Integer.parseInt(text);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
