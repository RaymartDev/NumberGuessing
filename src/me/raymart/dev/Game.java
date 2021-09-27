package me.raymart.dev;

import java.util.Random;
import java.util.Scanner;

public class Game {

    private final int boundary;
    private final Scanner scanner;
    private boolean isEnded = false;
    private final int randomNumber;
    private int guess;
    private final long startTime;
    public Game(int boundary, Scanner scanner) {
        this.boundary = boundary;
        this.scanner = scanner;
        this.randomNumber = new Random().nextInt(boundary);
        this.guess = 0;
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        System.out.println("Game has commenced!");

        while(!isEnded) {
            System.out.println("Please pick a number between 1 to " + boundary + ".");
            String input = scanner.nextLine();

            while(!isInt(input)) {
                System.out.println("Please input correct number format!");
                input = scanner.nextLine();
            }
            int playerNumber = Integer.parseInt(input);
            addGuess();

            if(playerNumber == randomNumber) {
                isEnded = true;
                System.out.println("You successfully guessed the number!");
                System.out.println("Number of guess(es): " + guess);

                long seconds = (System.currentTimeMillis() - startTime) / 1000;

                System.out.println("It took: " + seconds + " second(s)");
            } else {

                if(playerNumber > randomNumber) {

                    int difference = playerNumber - randomNumber;

                    if(difference >= 5) {
                        System.out.println("Your guess is too high!");
                    } else {
                        System.out.println("Your guess is little high!");
                    }
                } else {

                    int difference = randomNumber - playerNumber;

                    if(difference >= 5) {
                        System.out.println("Your guess is too low!");
                    } else {
                        System.out.println("Your guess is little low!");
                    }
                }

            }
        }
    }

    private void addGuess() {
        this.guess += 1;
    }

    private boolean isInt(String text) {
        try{
            Integer.parseInt(text);
        }catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
