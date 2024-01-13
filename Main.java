//Tanisha Thakare
//Guessing Game

import java.util.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

 public static final int MAX = 100;
   public static void main(String[] args) {
      
      int randomNum = 0;
      Random numbe5r = new Random();
      Scanner console = new Scanner(System.in);
      boolean done = false;
      int countOfGames = 0;
      int totalCountOfGuesses = 0;
      
      // our best game is the lowest count of guesses
      //The bestGame variable can be any large integer because
      //The bestGame is the lowest amount of guesses, and 
      //it will not exceed this number.
      int bestGame = 6909383;
      
      while (!done) {
         //Gets a random number between 1 and MAX value (which in this
         //case is 100
         randomNum = (int) (Math.random() * MAX + 1);
         
         int guesses = playGame(console, randomNum);
         totalCountOfGuesses = totalCountOfGuesses + guesses;
         countOfGames++;
         if (guesses < bestGame) {
            bestGame = guesses;
         }
         done = areWeDone();
      }
      results(countOfGames, totalCountOfGuesses, bestGame);
   } 
   // returns the number of guesses that the user made in this one game.
   public static int playGame(Scanner console, int randomNum) { 
      boolean correctNum = false;
      int numOftries = 0;
      System.out.println("I'm thinking of a number between 1 and 100...");
      
      //Allows the user to guess as many times until they guess correctly.
      while (correctNum == false) {
         
         System.out.println("Your guess? ");
         int userGuess = console.nextInt();
         numOftries++;
         //If userGuess is less than the Random Generated Number
         //it prints:
         if (userGuess < randomNum) {
            System.out.println("It's higher.");         
         }
         //If guess is greater than the Random number
         //It prints:
         else if (userGuess > randomNum) {
            System.out.println("It's lower."); 
         }
         //If guess is equal to the random number
         else if (userGuess == randomNum) {
            correctNum = true;
            
            //If the user guessed the number in one try
            // it prints this:
            if (numOftries == 1) {
               System.out.print("You got it right in 1 guess.");
            //If the user guesses the number in more than 1 try
            //it prints this:
            } else {
               System.out.print("You got it right in " + numOftries + " guesses.");
            }  
         }
      }
      return numOftries;
   }  
   // ask the user if they want to play again
   // If the user replies with anything that starts with a Y,
   // then play again by returning false.
   // otherwise, return true
   public static boolean areWeDone() {
      Scanner console = new Scanner(System.in);
      System.out.println(" Play again? (y/n)");
      String userChoice = console.next();
     
      //if the user types anything that starts with a "y", then 
      //it returns false, which means that the game is not done
      // so it keeps going.
      if (userChoice.startsWith("y")) {
         return false;
      
      //if the user types anything else (literally anything else)  
      } else {
         return true;
      }
   }
    //Method for the results of the game(s)
    //Prints the results of the game overall with specific stats
    public static void results(int games, int numOftries, int bestGame) {
      System.out.println("Overall Results:");
      System.out.println("Total Games \t= " + games);
      System.out.println("Total Guesses \t= " + numOftries);
      System.out.printf("Guesses/game \t= %.1f\n", (double) numOftries /games );
      System.out.println("Best game \t\t= " + bestGame);
    } 
}